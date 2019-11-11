package com.mes.lcr.billing.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.mes.lcr.billing.dao.DailyDetailFileICDesc;
import com.mes.lcr.util.BillingUtil;

public class DailyDetailFileICDescRowMapper implements ResultSetExtractor<Map<String, DailyDetailFileICDesc>> {
	private static final Logger LOG = LoggerFactory.getLogger(DailyDetailFileICDescRowMapper.class);

	@Override
	public Map<String, DailyDetailFileICDesc> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, DailyDetailFileICDesc> dailyDetailFileICDescMap = new HashMap<>();
		while (rs.next()) {
			DailyDetailFileICDesc dailyDetailFileICDesc = new DailyDetailFileICDesc();
			dailyDetailFileICDesc.setRecId(rs.getLong("REC_ID"));
			dailyDetailFileICDesc.setCardType(rs.getString("CARD_TYPE"));
			dailyDetailFileICDesc.setIcCode(rs.getString("IC_CODE"));
			dailyDetailFileICDesc.setIcDesc(rs.getString("IC_DESC"));
			dailyDetailFileICDesc.setIcRate(rs.getDouble("IC_RATE"));
			dailyDetailFileICDesc.setIcRatePerItem(rs.getDouble("IC_PER_ITEM"));
			dailyDetailFileICDesc.setValidDateBegin(rs.getDate("VALID_DATE_BEGIN"));
			dailyDetailFileICDesc.setValidDateEnd(rs.getDate("VALID_DATE_END"));
			dailyDetailFileICDesc.setRegIcCode(rs.getString("REG_IC_CODE"));
			dailyDetailFileICDesc.setBaseRate(rs.getDouble("BASE_RATE"));
			dailyDetailFileICDesc.setBasePerItem(rs.getDouble("BASE_PER_ITEM"));
			final String generateCustomCheckCode = BillingUtil.generateCheckCodeFromDailyDetailFileICDescObj(rs.getString("CARD_TYPE"), rs.getString("IC_DESC"));
			if (generateCustomCheckCode != null) {
				dailyDetailFileICDesc.setCustomCheckCode(generateCustomCheckCode);
				dailyDetailFileICDescMap.put(generateCustomCheckCode, dailyDetailFileICDesc);
			}
			else {
				LOG.error("generateCustomCheckCode is null from BillingUtil.generateCheckCodeFromDailyDetailFileICDescObj to DailyDetailFileICDescRowMapper ");
			}

		}
		return dailyDetailFileICDescMap;
	}

}
