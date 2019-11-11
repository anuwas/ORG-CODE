package com.mes.lcr.billing.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.mes.lcr.billing.dao.MbsPricing;
import com.mes.lcr.util.BillingUtil;

public class MerchantRawPricingRowMapper implements ResultSetExtractor<Map<String, MbsPricing>> {
	private static final Logger LOG = LoggerFactory.getLogger(MerchantRawPricingRowMapper.class);

	@Override
	public Map<String, MbsPricing> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, MbsPricing> merchantRawPricingMap = new HashMap<>();
		while (rs.next()) {
			MbsPricing mbsPricing = new MbsPricing();
			mbsPricing.setMerchantNumber(rs.getLong("MERCHANT_NUMBER"));
			mbsPricing.setItemSubclass(rs.getString("ITEM_SUBCLASS"));
			mbsPricing.setRate(rs.getDouble("RATE"));
			mbsPricing.setPerItem(rs.getDouble("PER_ITEM"));
			mbsPricing.setItemType(rs.getInt("ITEM_TYPE"));
			if(rs.getLong("MERCHANT_NUMBER")!=0 && rs.getString("ITEM_SUBCLASS")!=null && rs.getInt("ITEM_TYPE")!=0) {
				final String checkCode = BillingUtil.generateCheckCodeFromPricingObj(rs.getLong("MERCHANT_NUMBER"), rs.getString("ITEM_SUBCLASS"), rs.getInt("ITEM_TYPE"));
				merchantRawPricingMap.put(checkCode, mbsPricing);
			}
			else {
				LOG.info("Checkcode found would not be generated as MERCHANT_NUMBER {}, ITEM_SUBCLASS {}, ITEM_TYPE {} not found ",rs.getLong("MERCHANT_NUMBER"),rs.getString("ITEM_SUBCLASS"),rs.getInt("ITEM_TYPE"));
			}

		}
		return merchantRawPricingMap;
	}
}
