package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionService {
	public ConnectionInfoVO getConnectionInfo(ConnectionInfoVO ci);
	List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci);
	Map insertConnectionInfo(Map map,ConnectionInfoVO ci);
	List<Map<String, Object>> getDatabaseList();
	List<TableVO> getTableList(String dbName);
	List<ColumnVO> getColumnList(String tbName);
}
