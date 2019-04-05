package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import dao.AddrDAO;
import dao.impl.AddrDAOImpl;

public class AddrDAOTest {
	AddrDAO adao = new AddrDAOImpl();

	// @ : Java Annotation, 쓸수있는 어노테이션 5개
	@Test
	public void test1() {
		Map<String, String> addr = new HashMap<>();
		addr.put("sNum", "11");
		addr.put("lNum", "20");
		List<Map<String, String>> addrList = adao.selectAddrList(addr);
		assertEquals(10, addrList.size());
	}

	@Test
	public void addrCountTest() {
//		int totalCnt = adao.selectTotalAddrCnt();
//		assertEquals(358425, totalCnt);
	}
}
