package com.footforward.microservicerisk.proxy;

import com.footforward.microservicerisk.beans.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Declare the microservice-note endpoint
 */
@FeignClient(name = "microservice-note", url = "microservice-note:9002")
public interface INoteProxy {
    
    /**
     * @see com.footforward.microservicenote.controllers
     */
    @RequestMapping(method = RequestMethod.GET, value = "/patHistory/list")
    List<NoteBean> getNotes(@RequestParam("patId") Integer patId);
    
    /**
     * @see com.footforward.microservicenote.controllers
     */
    @RequestMapping(method = RequestMethod.GET, value = "/patHistory")
    NoteBean getNote(@RequestParam("id") Integer id);
    
    /**
     * @see com.footforward.microservicenote.controllers
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/patHistory/update")
    NoteBean updateNote(@RequestBody @Valid NoteBean note);
    
    /**
     * @see com.footforward.microservicenote.controllers
     */
    @RequestMapping(method = RequestMethod.POST, value = "/patHistory/add")
    NoteBean addNote(@RequestBody @Valid NoteBean note);
    
}
