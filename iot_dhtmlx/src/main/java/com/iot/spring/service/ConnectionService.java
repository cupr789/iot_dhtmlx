package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ConnectionInfoVO;

public interface ConnectionService {
	public ConnectionInfoVO getConnectionInfo(ConnectionInfoVO ci);
	List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci);
	Map insertConnectionInfo(Map map,ConnectionInfoVO ci);
}
