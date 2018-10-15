package java_base.concurrent;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Cha1_servletunsafe_atomic implements Servlet{
	private final AtomicLong count = new AtomicLong(0); 
	
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		count.incrementAndGet();
		encodeIntoResponse(res, factors);
	}
	
	
	private BigInteger[] factor(BigInteger i) {
		// TODO Auto-generated method stub
		return null;
	}


	private void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
		// TODO Auto-generated method stub
		
	}


	private BigInteger extractFromRequest(ServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
