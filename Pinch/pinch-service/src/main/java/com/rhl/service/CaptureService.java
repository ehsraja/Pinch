package com.rhl.service;

import java.util.List;

public interface CaptureService {
	
	public void register();
	public void addHeader (List <Object> header);
	public void capture (List <Object> capture);

}
