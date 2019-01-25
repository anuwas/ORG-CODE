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
import com.me.lc.billing.dto.AcDtrHdrDataCount;
import com.me.lc.billing.dto.MBDS;
import com.me.ps.billing.exception.BillingException;

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
	private AcBillingRepositoryImpl AcBillingRepositoryImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	       MockitoAnnotations.initMocks(this);
	 }
	
	
	private static final String QUERY_FETCH_FILETYPE_COUNT = "SELECT COUNT(1) FROM FILENAME_POSTFIX WHERE FILE_TYPE = ?";
	private static final String QUERY_SELECT_FILENAME_POSTFIX = "SELECT LAST_DATE,LAST_COUNT FROM FILENAME_POSTFIX WHERE FILE_TYPE = ?";
	private static final String Ac_SETTLEMENT_HDR_DTR_COMPARE = "SELECT  ( SELECT HDR.NUM_OF_RECORDS FROM   me.Ac_SETTLEMENT_FILE_HDR HDR where HDR.LOADFILE_NAME= ? ) AS HDR_COUNT,   ( SELECT COUNT(*) FROM   me.Ac_SETTLEMENT_FILE_DTR DTR LEFT JOIN me.Ac_SETTLEMENT_FILE_HDR HDR ON HDR.HDR_SEQ_NUM=DTR.HDR_SEQ_NUM   WHERE HDR.LOADFILE_NAME = ? ) AS DTR_COUNT FROM  dual";

	

	@Test
	public void callLoadFileIndexTest() {
		AcBillingRepositoryImpl.callLoadFileIndex("lc_3941");
		AcBillingRepositoryImpl.callLoadFileIndex(null);
		Mockito.when(jdbcTemplate.queryForObject("SELECT load_file_id FROM load_file_index WHERE load_filename = ?", Long.class, "lc_3941")).thenReturn((long) 1234);
		long loadfileId = AcBillingRepositoryImpl.callLoadFileIndex("lc_3941");
		Assert.assertEquals(1234, loadfileId);
	}
	
	
	@Test
	public void insertIncomeExpenseIntoMBDSTest() throws SQLException {
		
		Mockito.when(c.prepareStatement(Mockito.any(String.class))).thenReturn(ps);
		
		List<MBDSIncomeExpense> MBDSIncomeExpenselist = provideMBDSIncomeExpense();
		Mockito.when(jdbcTemplate.batchUpdate("SQL", new BatchPreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				try {
					ps.setLong(1, MBDSIncomeExpenselist.get(i).getMerchantNumber());
					ps.setDate(2, new java.sql.Date(MBDSIncomeExpenselist.get(i).getActivityDate().getTime()));
					ps.setInt(3, MBDSIncomeExpenselist.get(i).getItemType());
					ps.setString(4, MBDSIncomeExpenselist.get(i).getItemSubclass());
					ps.setString(5, MBDSIncomeExpenselist.get(i).getIcCat());
					ps.setInt(6, MBDSIncomeExpenselist.get(i).getItemCount());
					ps.setDouble(7, MBDSIncomeExpenselist.get(i).getItemAmount());
					ps.setInt(8, MBDSIncomeExpenselist.get(i).getSalesCount());
					ps.setDouble(9, MBDSIncomeExpenselist.get(i).getSalesAmount());
					ps.setInt(10, MBDSIncomeExpenselist.get(i).getCreditCount());
					ps.setDouble(11, MBDSIncomeExpenselist.get(i).getCreditAmount());
					ps.setDouble(12, MBDSIncomeExpenselist.get(i).getRate());
					ps.setDouble(13, MBDSIncomeExpenselist.get(i).getPerItem());
					ps.setDouble(14, MBDSIncomeExpenselist.get(i).getFeesDue());
					ps.setDouble(15, MBDSIncomeExpenselist.get(i).getFeesPaid());
					ps.setDouble(16, MBDSIncomeExpenselist.get(i).getExpense());
					ps.setString(17, MBDSIncomeExpenselist.get(i).getDataSourceName());
					ps.setLong(18, MBDSIncomeExpenselist.get(i).getDataSourceId());
					ps.setInt(19, 0);
					ps.setDouble(20, MBDSIncomeExpenselist.get(i).getExpenseActual());

				}
				catch (SQLException e) {
					throw new BillingException("Failed in AcBillingRepositoryImpl.insertIncomeExpenseIntoMBDS : ", e);
				}
			}

			@Override
			public int getBatchSize() {
				return MBDSIncomeExpenselist.size();
			}
		})).thenReturn(new int[] {1});
		
		AcBillingRepositoryImpl.insertIncomeExpenseIntoMBDS(provideMBDSIncomeExpense());
		List<MBDSIncomeExpense> MBDSIncomeExpenseList = new ArrayList<>();
		AcBillingRepositoryImpl.insertIncomeExpenseIntoMBDS(MBDSIncomeExpenseList);
		List<MBDSIncomeExpense> MBDSIncomeExpenseList1 = null;
		AcBillingRepositoryImpl.insertIncomeExpenseIntoMBDS(MBDSIncomeExpenseList1);
		AcBillingRepositoryImpl.insertIncomeExpenseIntoMBDS(null);
	}
	
	@Test
	public void loadACHSummaryTest() {
		AcBillingRepositoryImpl.loadACHSummary("lc-3941");
		Mockito.when(jdbcTemplate.update("call load_ach_summary(?)", "lc-3941")).thenReturn(0);
		
		AcBillingRepositoryImpl.loadACHSummary("lc-3941");
		Mockito.when(jdbcTemplate.update("call load_ach_summary(?)", "lc-3941")).thenReturn(1);
		
		AcBillingRepositoryImpl.loadACHSummary("lc-3941");
		Mockito.when(jdbcTemplate.update("call load_ach_summary(?)", "lc-3941")).thenReturn(-1);
		
		AcBillingRepositoryImpl.loadACHSummary("lc-3941");
		Mockito.when(jdbcTemplate.update("call load_ach_summary(?)", "lc-3941")).thenReturn(2);
		
		AcBillingRepositoryImpl.loadACHSummary("");
	}
	
	@Test
	public void generateFileIdSequenceTest() {
		String fileType = "FileType";
		String dateString = "2018-01-01";
		
		int loadFileSequence = 0;
		
		loadFileSequence = AcBillingRepositoryImpl.generateFileIdSequence("", "2018-01-01");
		Assert.assertEquals(0, loadFileSequence);
		
		loadFileSequence = AcBillingRepositoryImpl.generateFileIdSequence("FileType", "2018-01-01");
		
		Assert.assertEquals(0, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(2);
		loadFileSequence = AcBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(212, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(0);
		loadFileSequence = AcBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(1, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(1);
		Mockito.when(jdbcTemplate.queryForObject(QUERY_SELECT_FILENAME_POSTFIX, new Object[] {fileType}, new FileNamePostFixMapper())).thenReturn(null);
		loadFileSequence = AcBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(212, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(1);
		Mockito.when(this.jdbcTemplate.queryForObject(QUERY_SELECT_FILENAME_POSTFIX, new Object[] {fileType}, new FileNamePostFixMapper())).thenReturn(provideFileNamePostFix1());
		loadFileSequence = AcBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(212, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(1);
		Mockito.when(jdbcTemplate.queryForObject(QUERY_SELECT_FILENAME_POSTFIX, new Object[] {fileType}, new FileNamePostFixMapper())).thenReturn(provideFileNamePostFix2());
		loadFileSequence = AcBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(212, loadFileSequence);
		
		Mockito.when(jdbcTemplate.queryForObject(QUERY_FETCH_FILETYPE_COUNT, new Object[] {fileType}, Integer.class)).thenReturn(1);
		Mockito.when(jdbcTemplate.queryForObject(QUERY_SELECT_FILENAME_POSTFIX, new Object[] {fileType}, new FileNamePostFixMapper())).thenReturn(provideFileNamePostFix3());
		loadFileSequence = AcBillingRepositoryImpl.generateFileIdSequence(fileType, "2018-01-01");
		Assert.assertEquals(212, loadFileSequence);
	}
	
	@Test
	public void getListofSettlementFilesnotBilledTest() {
		List<String> fileLIst = new ArrayList<>();
		
		fileLIst = AcBillingRepositoryImpl.getListofSettlementFilesnotBilled("2018-01-01");
		Assert.assertEquals(new ArrayList<>(), fileLIst);
		Mockito.when(jdbcTemplate.query(Ac_SETTLEMENT_HDR_DTR_COMPARE, new Object[] {"lc_3941"}, new AcDtrHdrDataCount())).thenReturn(true);
		fileLIst = AcBillingRepositoryImpl.getListofSettlementFilesnotBilled("2018-01-01");
		Assert.assertEquals(new ArrayList<>(), fileLIst);
		Mockito.when(jdbcTemplate.query(Ac_SETTLEMENT_HDR_DTR_COMPARE, new Object[] {"lc_3941"}, new AcDtrHdrDataCount())).thenReturn(false);
		fileLIst = AcBillingRepositoryImpl.getListofSettlementFilesnotBilled("2018-01-01");
		Assert.assertEquals(new ArrayList<>(), fileLIst);
	}
	
	@Test
	public void cleanAcDailyBillingDataByLoadfileDateTest() {
		List<String> fileName = Arrays.asList(new String("lc_3941"),new String("lc_3941"));
		boolean cleanApiStatus = false;
		cleanApiStatus = AcBillingRepositoryImpl.cleanAcDailyBillingDataByLoadfileDate("2018-01-01", fileName);
		Assert.assertEquals(true, cleanApiStatus);
		
		List<String> fileName1 = new ArrayList<>();
		cleanApiStatus = AcBillingRepositoryImpl.cleanAcDailyBillingDataByLoadfileDate("2018-01-01", fileName1);
		Assert.assertEquals(true, cleanApiStatus);
		
		List<String> fileName2 = null;
		cleanApiStatus = AcBillingRepositoryImpl.cleanAcDailyBillingDataByLoadfileDate("2018-01-01", fileName2);
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
	

	public List<MBDSIncomeExpense> provideMBDSIncomeExpense(){
		List<MBDSIncomeExpense> MBDSIncomeExpenseList = new ArrayList<>();
		MBDSIncomeExpense MBDSIncomeExpenseObj1 = new MBDSIncomeExpense();
		MBDSIncomeExpenseObj1.setMerchantNumber(3490001L);
		MBDSIncomeExpenseObj1.setItemType(227);
		MBDSIncomeExpenseObj1.setItemSubclass("VP");
		MBDSIncomeExpenseObj1.setActivityDate(new Date());
		MBDSIncomeExpenseObj1.setExpense(20.17);
		MBDSIncomeExpenseObj1.setExpenseActual(20.17);
		MBDSIncomeExpenseObj1.setSalesCount(20);
		MBDSIncomeExpenseObj1.setSalesAmount(120.20);
		MBDSIncomeExpenseObj1.setCreditCount(1);
		MBDSIncomeExpenseObj1.setCreditAmount(1);
		MBDSIncomeExpenseObj1.setItemCount(1);
		MBDSIncomeExpenseObj1.setItemAmount(20);
		MBDSIncomeExpenseObj1.setDataSourceName("lc_3941_001");
		MBDSIncomeExpenseObj1.setDataSourceId(10001);
		MBDSIncomeExpenseObj1.setRate(1.20);
		MBDSIncomeExpenseObj1.setPerItem(2.20);
		MBDSIncomeExpenseObj1.setFeesPaid(2.20);
		MBDSIncomeExpenseObj1.setFeesDue(1.20);
		MBDSIncomeExpenseObj1.setNetwork("STAR");
		MBDSIncomeExpenseObj1.setRegulatedIndicator("U");
		MBDSIncomeExpenseObj1.setIcCat("A1");
		MBDSIncomeExpenseList.add(MBDSIncomeExpenseObj1);
		return MBDSIncomeExpenseList;
	}
	
	public MBDS provideMBDS() {
		MBDS MBDS = new MBDS();
		MBDS.setRecId(1234);
		MBDS.setMerchantNumber(94389990);
		MBDS.setActivityDate(new Date());
		MBDS.setItemType(227);
		MBDS.setItemSubclass("VP");
		MBDS.setSaleCount(1);
		MBDS.setItemCount(1);
		MBDS.setItemAmount(1);
		MBDS.setSaleAmount(1);
		MBDS.setCreditCount(1);
		MBDS.setCreditAmount(100);
		MBDS.setFeesDue(12);
		MBDS.setFeesPaid(12);
		MBDS.setExpense(23.40);
		MBDS.setExpenseActual(34.40);
		MBDS.setDataSource("lc_3941");
		MBDS.setDataSourceId(1234);
		return MBDS;
	}
	
	public List<DailyDetailFileDtDetail> provideDailyDetailFileDtDetail() {
		List<DailyDetailFileDtDetail> dailyDetailFileDtDetail = new ArrayList<>();
		DailyDetailFileDtDetail obj1 = new DailyDetailFileDtDetail();
		obj1.setAssociationNum(1223);
		dailyDetailFileDtDetail.add(obj1);
		return dailyDetailFileDtDetail;
	}
}
