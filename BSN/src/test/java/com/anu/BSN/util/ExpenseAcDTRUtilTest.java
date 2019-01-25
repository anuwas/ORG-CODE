package com.anu.BSN.util;

import java.lang.reflect.Constructor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.me.lc.bil.dao.AcclynkSettlementFileDTR;
import com.me.lc.bil.dao.mbDSIncomeExpense;
import com.me.lc.util.ExpenseAcDTRUtil;

public class ExpenseAcDTRUtilTest {
	public static final String DATE_FORMAT_DD_MM_YY = "dd/MM/yyyy";
	public static final String CARD_TYPE_VP = "VP";
	public static final String CARD_TYPE_MP = "MP";
	public static final int AcSWITCHFEE = 227;
	public static final int DEBITNETWORKINTERCHANGE = 111;
	public static final int DEBITNETWORKFEE = 229;
	public static final int DEBITDISCOUNTFEE = 101;
	public static final int AUTHFEE = 1;

	@Test
	public void manupulateExpenseFromAcDTRTest() throws ParseException {
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
		List<mbDSIncomeExpense> mbDSExpense = ExpenseAcDTRUtil.manupulateExpenseFromAcDTR(acclynkSettlementFileDTRList);

		mbDSIncomeExpense mbDSExpenseObjVP = mbDSExpense.get(0);
		Assert.assertEquals(CARD_TYPE_VP, mbDSExpenseObjVP.getItemSubclass());
		
		mbDSIncomeExpense mbDSExpenseObjVP227 = mbDSExpense.get(0);
		Assert.assertEquals(AcSWITCHFEE, mbDSExpenseObjVP227.getItemType());
		Assert.assertEquals(3.20, mbDSExpenseObjVP227.getExpense(),0);
		
		mbDSIncomeExpense mbDSExpenseObjVP111 = mbDSExpense.get(1);
		Assert.assertEquals(DEBITNETWORKINTERCHANGE, mbDSExpenseObjVP111.getItemType());
		Assert.assertEquals(2.20, mbDSExpenseObjVP111.getExpense(),0);
		
		mbDSIncomeExpense mbDSExpenseObjVP229 = mbDSExpense.get(2);
		Assert.assertEquals(DEBITNETWORKFEE, mbDSExpenseObjVP229.getItemType());
		Assert.assertEquals(1.20, mbDSExpenseObjVP229.getExpense(),0);
		
		mbDSIncomeExpense mbDSExpenseObjVP101 = mbDSExpense.get(3);
		Assert.assertEquals(DEBITDISCOUNTFEE, mbDSExpenseObjVP101.getItemType());
		Assert.assertEquals(0, mbDSExpenseObjVP101.getExpense(),0);
		
		mbDSIncomeExpense mbDSAuthVP = mbDSExpense.get(4);
		Assert.assertEquals(AUTHFEE, mbDSAuthVP.getItemType());
		Assert.assertEquals(0, mbDSAuthVP.getExpense(),0);
		

		mbDSIncomeExpense mbDSExpenseObjMP = mbDSExpense.get(5);
		Assert.assertEquals(CARD_TYPE_MP, mbDSExpenseObjMP.getItemSubclass());
		
		mbDSIncomeExpense mbDSExpenseObjMP227 = mbDSExpense.get(5);
		Assert.assertEquals(AcSWITCHFEE, mbDSExpenseObjMP227.getItemType());
		Assert.assertEquals(3.20, mbDSExpenseObjMP227.getExpense(),0);
		
		mbDSIncomeExpense mbDSExpenseObjMP111 = mbDSExpense.get(6);
		Assert.assertEquals(DEBITNETWORKINTERCHANGE, mbDSExpenseObjMP111.getItemType());
		Assert.assertEquals(2.20, mbDSExpenseObjMP111.getExpense(),0);
		
		mbDSIncomeExpense mbDSExpenseObjMP229 = mbDSExpense.get(7);
		Assert.assertEquals(DEBITNETWORKFEE, mbDSExpenseObjMP229.getItemType());
		Assert.assertEquals(1.20, mbDSExpenseObjMP229.getExpense(),0);
		
		mbDSIncomeExpense mbDSExpenseObjMP101 = mbDSExpense.get(8);
		Assert.assertEquals(DEBITDISCOUNTFEE, mbDSExpenseObjMP101.getItemType());
		Assert.assertEquals(0, mbDSExpenseObjMP101.getExpense(),0);
		
		mbDSIncomeExpense mbDSAuthMP = mbDSExpense.get(9);
		Assert.assertEquals(AUTHFEE, mbDSAuthMP.getItemType());
		Assert.assertEquals(0, mbDSAuthMP.getExpense(),0);
		
		List<AcclynkSettlementFileDTR> acclynkSettlementFileDTRListEmpty = null;
		List<mbDSIncomeExpense> mbDSExpenseempty = ExpenseAcDTRUtil.manupulateExpenseFromAcDTR(acclynkSettlementFileDTRListEmpty);
		Assert.assertEquals(new ArrayList<>(), mbDSExpenseempty);
	}
	
	@Test
	public void checkPrivateConstructor(){
		try {
			Constructor<ExpenseAcDTRUtil> c = ExpenseAcDTRUtil.class.getDeclaredConstructor();
			c.setAccessible(true); 
			ExpenseAcDTRUtil bu = c.newInstance();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
