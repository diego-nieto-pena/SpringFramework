package com.service.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulPostTimer extends ZuulFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(ZuulPostTimer.class);
	
	@Override
	public boolean shouldFilter() {
		return true; //validate if the filter should be executed
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		logger.info("Starting post filter " + request.getRequestURI());
		
		Long startTime = (Long) request.getAttribute("startTime");
		Long endingTime = System.currentTimeMillis();
		Long totalTime = startTime -endingTime;
		
		logger.info(String.format("Time in seconds: %s seconds", totalTime.doubleValue()/1000.00));
		
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
