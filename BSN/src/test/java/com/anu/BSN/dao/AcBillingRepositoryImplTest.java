package com.anu.BSN.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mes.lcr.billing.dto.AcculynkDtrHdrDataCount;
import com.mes.lcr.billing.dto.MbsDailySummary;
import com.mes.ps.billing.exception.BillingException;

@RunWith(SpringJUnit4ClassRunner.class)
public class AcBillingRepositoryImplTest {
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	 @Mock
	 private Connection c;
	
	@Mock
	private PreparedStatement ps;
	
	@Mock
	private ResultSet rs;
	
	@InjectMocks
	private AcculynkBillingRepositoryImpl acculynkBillingRepositoryImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	
	private static final String QUERY_FETCH_FILETYPE_COUNT = "SELECT COUNT(1) FROM FILENAME_POSTFIX WHERE FILE_TYPE = ?";
	private static final String QUERY_SELECT_FILENAME_POSTFIX = "SELECT LAST_DATE,LAST_COUNT FROM FILENAME_POSTFIX WHERE FILE_TYPE = ?";
	private static final String ACCULYNK_SETTLEMENT_HDR_DTR_COMPARE = "SELECT  ( SELECT HDR.NUM_OF_RECORDS FROM   MES.ACCULYNK_SETTLEMENT_FILE_HDR HDR where HDR.LOADFILE_NAME= ? ) AS HDR_COUNT,   ( SELECT COUNT(*) FROM   MES.ACCULYNK_SETTLEMENT_FILE_DTR DTR LEFT JOIN MES.ACCULYNK_SETTLEMENT_FILE_HDR HDR ON HDR.HDR_SEQ_NUM=DTR.HDR_SEQ_NUM   WHERE HDR.LOADFILE_NAME = ? ) AS DTR_COUNT FROM  dual";

	

	@Test
	public void callLoadFileIndexTest() {
		acculynkBillingRepositoryImpl.callLoadFileIndex("lcr_3941");
		acculynkBillingRepositoryImpl.callLoadFileIndex(null);
		Mockito.when(jdbcTemplate.queryForObject("SELECT load_file_id FROM load_file_index WHERE load_filename = ?", Long.class, "lcr_3941")).thenReturn((long) 1234);
		long loadfileId = acculynkBillingRepositoryImpl.callLoadFileIndex("lcr_3941");
		Assert.assertEquals(1234, loadfileId);
	}
	
	
	@Test
	public void insertIncomeExpenseIntoMbsDailySummaryTest() throws SQLException {
		
		Mockito.when(c.prepareStatement(Mockito.any(String.class))).thenReturn(ps);
		
		List<MBSDailySummaryIncomeExpense> mbsDailySummaryIncomeExpenselist = provideMBSDailySummaryIncomeExpense();
		Mockito.when(jdbcTemplate.batchUpdate("SQL", new BatchPreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				try {
					ps.setLong(1, mbsDailySummaryIncomeExpenselist.get(i).getMerchantNumber());
					ps.setDate(2, new java.sql.Date(mbsDailySummaryIncomeExpenselist.get(i).getActivityDate().getTime()));
					ps.setInt(3, mbsDailySummaryIncomeExpenselist.get(i).getItemType());
					ps.setString(4, mbsDailySummaryIncomeExpenselist.get(i).getItemSubclass());
					ps.setString(5, mbsDailySummaryIncomeExpenselist.get(i).getIcCat());
					ps.setInt(6, mbsDailySummaryIncomeExpenselist.get(i).getItemCount());
					ps.setDouble(7, mbsDailySummaryIncomeExpenselist.get(i).getItemAmount());
					ps.setInt(8, mbsDailySummaryIncomeExpenselist.get(i).getSalesCount());
					ps.setDouble(9, mbsDailySummaryIncomeExpenselist.get(i).getSalesAmount());
					ps.setInt(10, mbsDailySummaryIncomeExpenselist.get(i).getCreditCount());
					ps.setDouble(11, mbsDailySummaryIncomeExpenselist.get(i).getCreditAmount());
					ps.setDouble(12, mbsDailySummaryIncomeExpenselist.get(i).getRate());
					ps.setDouble(13, mbsDailySummaryIncomeExpenselist.get(i).getPerItem());
					ps.setDouble(14, mbsDailySummaryIncomeExpenselist.get(i).getFeesDue());
					ps.setDouble(15, mbsDailySummaryIncomeExpenselist.get(i).getFeesPaid());
					ps.setDouble(16, mbsDailySummaryIncomeExpenselist.get(i).getExpense());
					ps.setString(17, mbsDailySummaryIncomeExpenselist.get(i).getDataSourceName());
					ps.setLong(18, mbsDailySummaryIncomeExpenselist.get(i).getDataSourceId());
					ps.setInt(19, 0);
					ps.setDouble(20, mbsDailySummaryIncomeExpenselist.get(i).getExpenseActual());

				}
				catch (SQLException e) {
					throw new BillingException("Failed in AcculynkBillingRepositoryImpl.insertIncomeExpenseIntoMbsDailySummary : ", e);
				}
			}

			@Override
			public int getBatchSize() {
				return mbsDailySummaryIncomeExpenselist.size();
			}
		})).thenReturn(new int[] {1});
		
		acculynkBillingRepositoryImpl.insertIncomeExpenseIntoMbsDailySummary(provideMBSDailySummaryIncomeExpense());
		List<MBSDailySummaryIncomeExpense> mBSDailySummaryIncomeExpenseList = new ArrayList<>();
		acculynkBillingRepositoryImpl.insertIncomeExpenseIntoMbsDailySummary(mBSDailySummaryIncomeExpenseList);
		List<MBSDailySummaryIncomeExpense> mBSDailySummaryIncomeExpenseList1 = null;
		acculynkBillingRepositoryImpl.insertIncomeExpenseIntoMbsDailySummary(mBSDailySummaryIncomeExpenseList1);
		acculynkBillingRepositoryImpl.insertIncomeExpenseIntoMbsDailySummary(null);
	}
	
	@Test
	public void loadACHSummaryTest() {
		acculynkBillingRepositoryImpl.loadACHSummary("lcr-3941");
		Mockito.when(jdbcTemplate.update("call load_ach_summary(?)", "lcr-3941")).thenReturn(0);
		
		acculynkBillingRepositoryImpl.loadACHSummary("lcr-3941");
		Mockito.when(jdbcTemplate.update("call load_ach_summary(?)", "lcr-3941")).thenReturn(1);
		
		acculynkBillingRepositoryImpl.loadACHSummary("lcr-3941");
		Mockito.when(jdbcTemplate.update("call load_ach_summary(?)", "lcr-3941")).thenReturn(-1);
		
		acculynkBillingRepositoryImpl.loadACHSummary("lcr-3941");
		Mockito.when(jdbcTemplate.update("call load_ach_summary(?)", "lcr-3941")).thenReturn(2);
		
		acculynkBillingRepositoryImpl.loadACHSummary("");
	}
	
	@Test
	public void generateFileIdSequenceTest() {
		String fileType = "FileType";
		String dateString = "2018-01-01";
		
		int loadFileSequence = 0;
		
		loadFileSequence = acculynkBillingRepositoryImpl.generateFileIdSequence("", "2018-01-01");
		Assert.assertEquals(0, loadFileSequence);
		
		loadFileSequence = acculynkBillingRepositoryImpl.generateFileIdSequence("FileType", "2018-01-01");
		
		Assert.assertEquals(0, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(2);
		loadFileSequence = acculynkBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(212, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(0);
		loadFileSequence = acculynkBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(1, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(1);
		Mockito.when(jdbcTemplate.queryForObject(QUERY_SELECT_FILENAME_POSTFIX, new Object[] {fileType}, new FileNamePostFixMapper())).thenReturn(null);
		loadFileSequence = acculynkBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(212, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(1);
		Mockito.when(this.jdbcTemplate.queryForObject(QUERY_SELECT_FILENAME_POSTFIX, new Object[] {fileType}, new FileNamePostFixMapper())).thenReturn(provideFileNamePostFix1());
		loadFileSequence = acculynkBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(212, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(1);
		Mockito.when(jdbcTemplate.queryForObject(QUERY_SELECT_FILENAME_POSTFIX, new Object[] {fileType}, new FileNamePostFixMapper())).thenReturn(provideFileNamePostFix2());
		loadFileSequence = acculynkBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(212, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(1);
		Mockito.when(jdbcTemplate.queryForObject(QUERY_SELECT_FILENAME_POSTFIX, new Object[] {fileType}, new FileNamePostFixMapper())).thenReturn(provideFileNamePostFix3());
		loadFileSequence = acculynkBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(212, loadFileSequence);
	}
	
	@Test
	public void getListofSettlementFilesnotBilledTest() {
		List<String> fileLIst = new ArrayList<>();
		
		fileLIst = acculynkBillingRepositoryImpl.getListofSettlementFilesnotBilled("2018-01-01");
		Assert.assertEquals(new ArrayList<>(), fileLIst);
		Mockito.when(jdbcTemplate.query(ACCULYNK_SETTLEMENT_HDR_DTR_COMPARE, new Object[] {"lcr_3941"}, new AcculynkDtrHdrDataCount())).thenReturn(true);
		fileLIst = acculynkBillingRepositoryImpl.getListofSettlementFilesnotBilled("2018-01-01");
		Assert.assertEquals(new ArrayList<>(), fileLIst);
		Mockito.when(jdbcTemplate.query(ACCULYNK_SETTLEMENT_HDR_DTR_COMPARE, new Object[] {"lcr_3941"}, new AcculynkDtrHdrDataCount())).thenReturn(false);
		fileLIst = acculynkBillingRepositoryImpl.getListofSettlementFilesnotBilled("2018-01-01");
		Assert.assertEquals(new ArrayList<>(), fileLIst);
	}
	
	@Test
	public void cleanAcculynkDailyBillingDataByLoadfileDateTest() {
		List<String> fileNames = Arrays.asList(new String("lcr_3941"),new String("lcr_3941"));
		boolean cleanApiStatus = false;
		cleanApiStatus = acculynkBillingRepositoryImpl.cleanAcculynkDailyBillingDataByLoadfileDate("2018-01-01", fileNames);
		Assert.assertEquals(true, cleanApiStatus);
		
		List<String> fileNames1 = new ArrayList<>();
		cleanApiStatus = acculynkBillingRepositoryImpl.cleanAcculynkDailyBillingDataByLoadfileDate("2018-01-01", fileNames1);
		Assert.assertEquals(true, cleanApiStatus);
		
		List<String> fileNames2 = null;
		cleanApiStatus = acculynkBillingRepositoryImpl.cleanAcculynkDailyBillingDataByLoadfileDate("2018-01-01", fileNames2);
		Assert.assertEquals(true, cleanApiStatus);
	}
	
	public FileNamePostFix provideFileNamePostFix1() {
		FileNamePostFix fileNamePostFix = new FileNamePostFix();
		fileNamePostFix.setFileType("FileType");
		fileNamePostFix.setDateString("2018-01-01");
		return fileNamePostFix;
	}
	
	public  FileNamePostFix provideFileNamePostFix2() {
		FileNamePostFix fileNamePostFix = new FileNamePostFix();
		fileNamePostFix.setFileType("fileType");
		fileNamePostFix.setDateString(null);
		fileNamePostFix.setFileId(1);
		return fileNamePostFix;
	}
	
	public FileNamePostFix provideFileNamePostFix3() {
		FileNamePostFix fileNamePostFix = new FileNamePostFix();
		fileNamePostFix.setFileType("fileType");
		fileNamePostFix.setDateString("2018-01-02");
		fileNamePostFix.setFileId(1);
		return fileNamePostFix;
	}
	

	public List<MBSDailySummaryIncomeExpense> provideMBSDailySummaryIncomeExpense(){
		List<MBSDailySummaryIncomeExpense> mBSDailySummaryIncomeExpenseList = new ArrayList<>();
		MBSDailySummaryIncomeExpense mbsDailySummaryIncomeExpenseObj1 = new MBSDailySummaryIncomeExpense();
		mbsDailySummaryIncomeExpenseObj1.setMerchantNumber(3490001L);
		mbsDailySummaryIncomeExpenseObj1.setItemType(227);
		mbsDailySummaryIncomeExpenseObj1.setItemSubclass("VP");
		mbsDailySummaryIncomeExpenseObj1.setActivityDate(new Date());
		mbsDailySummaryIncomeExpenseObj1.setExpense(20.17);
		mbsDailySummaryIncomeExpenseObj1.setExpenseActual(20.17);
		mbsDailySummaryIncomeExpenseObj1.setSalesCount(20);
		mbsDailySummaryIncomeExpenseObj1.setSalesAmount(120.20);
		mbsDailySummaryIncomeExpenseObj1.setCreditCount(1);
		mbsDailySummaryIncomeExpenseObj1.setCreditAmount(1);
		mbsDailySummaryIncomeExpenseObj1.setItemCount(1);
		mbsDailySummaryIncomeExpenseObj1.setItemAmount(20);
		mbsDailySummaryIncomeExpenseObj1.setDataSourceName("lcr_3941_001");
		mbsDailySummaryIncomeExpenseObj1.setDataSourceId(10001);
		mbsDailySummaryIncomeExpenseObj1.setRate(1.20);
		mbsDailySummaryIncomeExpenseObj1.setPerItem(2.20);
		mbsDailySummaryIncomeExpenseObj1.setFeesPaid(2.20);
		mbsDailySummaryIncomeExpenseObj1.setFeesDue(1.20);
		mbsDailySummaryIncomeExpenseObj1.setNetwork("STAR");
		mbsDailySummaryIncomeExpenseObj1.setRegulatedIndicator("U");
		mbsDailySummaryIncomeExpenseObj1.setIcCat("A1");
		mBSDailySummaryIncomeExpenseList.add(mbsDailySummaryIncomeExpenseObj1);
		return mBSDailySummaryIncomeExpenseList;
	}
	
	public MbsDailySummary provideMbsDailySummary() {
		MbsDailySummary mbsDailySummary = new MbsDailySummary();
		mbsDailySummary.setRecId(1234);
		mbsDailySummary.setMerchantNumber(94389990);
		mbsDailySummary.setActivityDate(new Date());
		mbsDailySummary.setItemType(227);
		mbsDailySummary.setItemSubclass("VP");
		mbsDailySummary.setSaleCount(1);
		mbsDailySummary.setItemCount(1);
		mbsDailySummary.setItemAmount(1);
		mbsDailySummary.setSaleAmount(1);
		mbsDailySummary.setCreditCount(1);
		mbsDailySummary.setCreditAmount(100);
		mbsDailySummary.setFeesDue(12);
		mbsDailySummary.setFeesPaid(12);
		mbsDailySummary.setExpense(23.40);
		mbsDailySummary.setExpenseActual(34.40);
		mbsDailySummary.setDataSource("lcr_3941");
		mbsDailySummary.setDataSourceId(1234);
		return mbsDailySummary;
	}
	
	public List<DailyDetailFileDtDetail> provideDailyDetailFileDtDetail() {
		List<DailyDetailFileDtDetail> dailyDetailFileDtDetail = new ArrayList<>();
		DailyDetailFileDtDetail obj1 = new DailyDetailFileDtDetail();
		obj1.setAssociationNum(1223);
		dailyDetailFileDtDetail.add(obj1);
		return dailyDetailFileDtDetail;
	}
}
