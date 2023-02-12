package com.example.toy_springboots.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.toy_springboots.service.PollService;
import com.example.toy_springboots.utils.PollUtil;

@Controller
@RequestMapping(value = "/poll")
public class PollController {

    @Autowired
    PollService pollService;
    
    @Autowired
    PollUtil pollUtil;
    
    @RequestMapping(value = {"/main", "", "/"}, method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView) {
        modelAndView.setViewName("/poll/main");
        return modelAndView;
    }

    // ------------------Security----------------------------
    @GetMapping({"/mainAuth"})
    public ModelAndView mainAuth(ModelAndView modelAndView){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
        } else {
            String username = principal.toString();
        }
        modelAndView.setViewName("/poll/main");
        System.out.println(((UserDetails)principal).getAuthorities());
        System.out.println(((UserDetails)principal).getPassword());
        System.out.println(((UserDetails)principal).getUsername());
        System.out.println(((UserDetails)principal).isAccountNonExpired());
        System.out.println(((UserDetails)principal).
        isAccountNonLocked());
        System.out.println(((UserDetails)principal).isCredentialsNonExpired());
        System.out.println(((UserDetails)principal).
        isEnabled());
        return modelAndView;
    }
    // ----------------------------------------------
    
        @GetMapping({"/user"})
        public ModelAndView user(ModelAndView modelAndView){
            modelAndView.setViewName("/user/read");
            return modelAndView;
        }

        
    
    @RequestMapping(value = { "/list"}, method = RequestMethod.GET)
    public ModelAndView list(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = pollService.fixedListAndPagination(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/poll/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/listPagination/{currentPage}"}, method = RequestMethod.GET)
    public ModelAndView listPagination(@RequestParam Map<String, Object> params
            , @PathVariable String currentPage, ModelAndView modelAndView) {
        params.put("currentPage", Integer.parseInt(currentPage));
        params.put("pageScale", 10);
        Object resultMap = pollService.listAndPagination(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/poll/list_pagination");
        return modelAndView;
    }

    @RequestMapping(value = {"/form"}, method = RequestMethod.GET)
    public ModelAndView form(@RequestParam HashMap<String, Object> params, ModelAndView modelAndView) {
        modelAndView.setViewName("/poll/form");
        return modelAndView;
    }
    
    @RequestMapping(value = {"/formMulti"}, method = RequestMethod.GET)
    public ModelAndView formMulti(@RequestParam HashMap<String, Object> params, ModelAndView modelAndView) {
        modelAndView.setViewName("/poll/formMulti");
        return modelAndView;
    }

    @RequestMapping(value = {"/edit/{userUid}"}, method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam Map<String, Object> params, @PathVariable String userUid, ModelAndView modelAndView) {
        params.put("USER_UID", userUid);
        Object resultMap = pollService.getOne(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("poll/form");
        return modelAndView;
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public ModelAndView insert(@RequestParam HashMap<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = pollService.insertAndList(params);
        resultMap = pollService.fixedListAndPagination(params);
        modelAndView.addObject("resultMap",resultMap);
        modelAndView.setViewName("/poll/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/insertMulti"}, method = RequestMethod.POST)
    public ModelAndView insertMulti(MultipartHttpServletRequest multipartHttpServletRequest, @RequestParam HashMap<String, Object> params, ModelAndView modelAndView) throws IllegalStateException, IOException {
        
        //PollUtil의 fileUpload 함수
        List attachFiles = pollUtil.fileUpload(multipartHttpServletRequest, params);
        
        params.put("attachFiles",attachFiles);
        Object resultMap = pollService.insertWithFileAndGetList(params);
        resultMap = pollService.fixedListAndPagination(params);
        modelAndView.addObject("resultMap",resultMap);
        modelAndView.setViewName("/poll/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public ModelAndView update(@RequestParam HashMap<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = pollService.updateAndList(params);
        resultMap = pollService.fixedListAndPagination(params);
        modelAndView.addObject("resultMap",resultMap);
        modelAndView.setViewName("/poll/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/updateMulti"}, method = RequestMethod.POST)
    public ModelAndView updateMulti(MultipartHttpServletRequest multipartHttpServletRequest, @RequestParam HashMap<String, Object> params, ModelAndView modelAndView) throws IllegalStateException, IOException {
        Object resultMap = pollService.fixedListAndPagination(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/poll/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/delete/{userUid}"}, method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam HashMap<String, Object> params, @PathVariable String userUid, ModelAndView modelAndView) {
        params.put("USER_UID",userUid);
        Object resultMap = pollService.deleteAndList(params);
        resultMap = pollService.fixedListAndPagination(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/poll/list_pagination");
        return modelAndView;
    }
    
    @RequestMapping(value = {"/addTestUser"}, method = RequestMethod.GET)
    public ModelAndView addTestUser(@RequestParam HashMap<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = pollService.insertTestUsersAndList(params);
        resultMap = pollService.fixedListAndPagination(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/poll/list");
        return modelAndView;
    }
}
