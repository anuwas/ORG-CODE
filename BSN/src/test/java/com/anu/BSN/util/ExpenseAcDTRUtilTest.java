package com.anu.BSN.util;

import java.lang.reflect.Constructor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.mes.lc.billing.dao.AcclynkSettlementFileDTR;
import com.mes.lc.billing.dao.MBSDailySummaryIncomeExpense;
import com.mes.lc.util.ExpenseAcculynkDTRUtil;

public class ExpenseAcDTRUtilTest {
	public static final String DATE_FORMAT_DD_MM_YY = "dd/MM/yyyy";
	public static final String CARD_TYPE_VP = "VP";
	public static final String CARD_TYPE_MP = "MP";
	public static final int ACCULYNKSWITCHFEE = 227;
	public static final int DEBITNETWORKINTERCHANGE = 111;
	public static final int DEBITNETWORKFEE = 229;
	public static final int DEBITDISCOUNTFEE = 101;
	public static final int AUTHFEE = 1;

	@Test
	public void manupulateExpenseFromAcculynkDTRTest() throws ParseException {
		AcclynkSettlementFileDTR acclynkSettlementFileDTR_VP = new AcclynkSettlementFileDTR();
		AcclynkSettlementFileDTR acclynkSettlementFileDTR_MP = new AcclynkSettlementFileDTR();
		long merchantNumber = 941000122088L;
		acclynkSettlementFileDTR_VP.setDtrSeqNum(111);
		acclynkSettlementFileDTR_VP.setMerchantNumber(merchantNumber);
		acclynkSettlementFileDTR_VP.setDtrSeqNum(112);
		acclynkSettlementFileDTR_VP.setSwitchfee(-0.20);
		acclynkSettlementFileDTR_VP.setNetworkfee(-0.02);
		acclynkSettlementFileDTR_VP.setInterchangeFee(0.0);
		acclynkSettlementFileDTR_VP.setCardtype(CARD_TYPE_VP);
		acclynkSettlementFileDTR_VP.setTransactionDateTime(new SimpleDateFormat(DATE_FORMAT_DD_MM_YY).parse("02/02/2018"));
		acclynkSettlementFileDTR_VP.setApprovalAmount(10);
		acclynkSettlementFileDTR_VP.setTransactionAmount(10);
		acclynkSettlementFileDTR_VP.setNetwork("STAR");
		acclynkSettlementFileDTR_VP.setSalesCount(3);
		acclynkSettlementFileDTR_VP.setSalesAmount(10);
		acclynkSettlementFileDTR_VP.setCreditCount(0);
		acclynkSettlementFileDTR_VP.setCreditAmount(0);
		acclynkSettlementFileDTR_VP.setItemCount(10);
		acclynkSettlementFileDTR_VP.setItemAmount(10);
		acclynkSettlementFileDTR_VP.setSwitchfee(3.20);
		acclynkSettlementFileDTR_VP.setInterchangeFee(2.20);
		acclynkSettlementFileDTR_VP.setNetworkfee(1.20);
		
		acclynkSettlementFileDTR_MP.setDtrSeqNum(111);
		acclynkSettlementFileDTR_MP.setMerchantNumber(merchantNumber);
		acclynkSettlementFileDTR_MP.setDtrSeqNum(113);
		acclynkSettlementFileDTR_MP.setSwitchfee(-0.30);
		acclynkSettlementFileDTR_MP.setNetworkfee(-0.03);
		acclynkSettlementFileDTR_MP.setInterchangeFee(0.0);
		acclynkSettlementFileDTR_MP.setCardtype(CARD_TYPE_MP);
		acclynkSettlementFileDTR_MP.setTransactionDateTime(new SimpleDateFormat(DATE_FORMAT_DD_MM_YY).parse("02/02/2018"));
		acclynkSettlementFileDTR_MP.setApprovalAmount(10);
		acclynkSettlementFileDTR_MP.setTransactionAmount(10);
		acclynkSettlementFileDTR_MP.setNetwork("STAR");
		acclynkSettlementFileDTR_MP.setSalesCount(3);
		acclynkSettlementFileDTR_MP.setSalesAmount(10);
		acclynkSettlementFileDTR_MP.setCreditCount(0);
		acclynkSettlementFileDTR_MP.setCreditAmount(0);
		acclynkSettlementFileDTR_MP.setItemCount(10);
		acclynkSettlementFileDTR_MP.setItemAmount(10);
		acclynkSettlementFileDTR_MP.setSwitchfee(3.20);
		acclynkSettlementFileDTR_MP.setInterchangeFee(2.20);
		acclynkSettlementFileDTR_MP.setNetworkfee(1.20);

		List<AcclynkSettlementFileDTR> acclynkSettlementFileDTRList = new ArrayList<>();
		acclynkSettlementFileDTRList.add(acclynkSettlementFileDTR_VP);
		acclynkSettlementFileDTRList.add(acclynkSettlementFileDTR_MP);
		List<MBSDailySummaryIncomeExpense> mBSDailySummaryExpense = ExpenseAcculynkDTRUtil.manupulateExpenseFromAcculynkDTR(acclynkSettlementFileDTRList);

		MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjVP = mBSDailySummaryExpense.get(0);
		Assert.assertEquals(CARD_TYPE_VP, mbsDailySummaryExpenseObjVP.getItemSubclass());
		
		MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjVP227 = mBSDailySummaryExpense.get(0);
		Assert.assertEquals(ACCULYNKSWITCHFEE, mbsDailySummaryExpenseObjVP227.getItemType());
		Assert.assertEquals(3.20, mbsDailySummaryExpenseObjVP227.getExpense(),0);
		
		MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjVP111 = mBSDailySummaryExpense.get(1);
		Assert.assertEquals(DEBITNETWORKINTERCHANGE, mbsDailySummaryExpenseObjVP111.getItemType());
		Assert.assertEquals(2.20, mbsDailySummaryExpenseObjVP111.getExpense(),0);
		
		MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjVP229 = mBSDailySummaryExpense.get(2);
		Assert.assertEquals(DEBITNETWORKFEE, mbsDailySummaryExpenseObjVP229.getItemType());
		Assert.assertEquals(1.20, mbsDailySummaryExpenseObjVP229.getExpense(),0);
		
		MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjVP101 = mBSDailySummaryExpense.get(3);
		Assert.assertEquals(DEBITDISCOUNTFEE, mbsDailySummaryExpenseObjVP101.getItemType());
		Assert.assertEquals(0, mbsDailySummaryExpenseObjVP101.getExpense(),0);
		
		MBSDailySummaryIncomeExpense mbsDailySummaryAuthVP = mBSDailySummaryExpense.get(4);
		Assert.assertEquals(AUTHFEE, mbsDailySummaryAuthVP.getItemType());
		Assert.assertEquals(0, mbsDailySummaryAuthVP.getExpense(),0);
		

		MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjMP = mBSDailySummaryExpense.get(5);
		Assert.assertEquals(CARD_TYPE_MP, mbsDailySummaryExpenseObjMP.getItemSubclass());
		
		MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjMP227 = mBSDailySummaryExpense.get(5);
		Assert.assertEquals(ACCULYNKSWITCHFEE, mbsDailySummaryExpenseObjMP227.getItemType());
		Assert.assertEquals(3.20, mbsDailySummaryExpenseObjMP227.getExpense(),0);
		
		MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjMP111 = mBSDailySummaryExpense.get(6);
		Assert.assertEquals(DEBITNETWORKINTERCHANGE, mbsDailySummaryExpenseObjMP111.getItemType());
		Assert.assertEquals(2.20, mbsDailySummaryExpenseObjMP111.getExpense(),0);
		
		MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjMP229 = mBSDailySummaryExpense.get(7);
		Assert.assertEquals(DEBITNETWORKFEE, mbsDailySummaryExpenseObjMP229.getItemType());
		Assert.assertEquals(1.20, mbsDailySummaryExpenseObjMP229.getExpense(),0);
		
		MBSDailySummaryIncomeExpense mbsDailySummaryExpenseObjMP101 = mBSDailySummaryExpense.get(8);
		Assert.assertEquals(DEBITDISCOUNTFEE, mbsDailySummaryExpenseObjMP101.getItemType());
		Assert.assertEquals(0, mbsDailySummaryExpenseObjMP101.getExpense(),0);
		
		MBSDailySummaryIncomeExpense mbsDailySummaryAuthMP = mBSDailySummaryExpense.get(9);
		Assert.assertEquals(AUTHFEE, mbsDailySummaryAuthMP.getItemType());
		Assert.assertEquals(0, mbsDailySummaryAuthMP.getExpense(),0);
		
		List<AcclynkSettlementFileDTR> acclynkSettlementFileDTRListEmpty = null;
		List<MBSDailySummaryIncomeExpense> mBSDailySummaryExpenseempty = ExpenseAcculynkDTRUtil.manupulateExpenseFromAcculynkDTR(acclynkSettlementFileDTRListEmpty);
		Assert.assertEquals(new ArrayList<>(), mBSDailySummaryExpenseempty);
	}
	
	@Test
	public void checkPrivateConstructor(){
		try {
			Constructor<ExpenseAcculynkDTRUtil> c = ExpenseAcculynkDTRUtil.class.getDeclaredConstructor();
			c.setAccessible(true); 
			ExpenseAcculynkDTRUtil bu = c.newInstance();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
