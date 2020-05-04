package com.kandy.zull.server.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class LoggingFilter extends ZuulFilter {

    private Logger logger=LoggerFactory.getLogger(this.getClass());  

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true; //Executing filter for every request..Kamlesh
	}

	@Override
	public Object run() throws ZuulException {
		
		//getting the current HTTP request that is to be handle by zuul 
		HttpServletRequest request=RequestContext.getCurrentContext().getRequest();  
		
		//prints the detail of the requestin the log  
		logger.info("request -> {} request uri-> {}", request, request.getRequestURI());  
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";  //intercept all the request before execution 
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;  //setting filter order to 1 
	}

}
