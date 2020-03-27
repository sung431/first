package com.ese.first.sample.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ese.first.common.common.CommandMap;
import com.ese.first.sample.service.SampleService;

@Controller
public class SampleController {
    Logger log = Logger.getLogger(this.getClass());
     
    @Resource(name="sampleService")
    private SampleService sampleService;
    
    @RequestMapping(value="/sample/openSampleList.do")
    public ModelAndView openSampleList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("sample/memberList");
        
        List<Map<String, Object>> list = sampleService.selsectMemberList(commandMap);
        mv.addObject("list", list);
        
        return mv;
    }
    
    @RequestMapping(value="/sample/testMapArgumentResolver.do")
    public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("");
    	
    	if(commandMap.isEmpty() == false) {
    		Iterator<Entry<String, Object>> iterator = commandMap.getMap().entrySet().iterator();
    		Entry<String, Object> entry = null;
    		while(iterator.hasNext()) {
    			entry = iterator.next();
    			log.debug("key : " + entry.getKey() + ", val : " + entry.getValue());
    		}
    	}
    	
    	return mv;
    }
    
    @RequestMapping(value="/sample/openMemberWrite.do")
    public ModelAndView openMemberWrite(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("sample/memberWrite");
    	
    	return mv;
    }
    
    @RequestMapping(value="/sample/insertMember.do")
    public ModelAndView insertMember(@RequestParam Map<String, Object> commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("redirect:/sample/openSampleList.do");
    	
    	sampleService.insertMember(commandMap);
    	System.out.println(commandMap.get("mname"));
    	System.out.println(commandMap.get("dno"));
    	
    	return mv;
    }
}
