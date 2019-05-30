package com.keystone.demo.Controller;


import com.keystone.demo.Entity.Mission;
import com.keystone.demo.Service.MissionService;
import com.keystone.demo.exceptionMission.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MissionController {
    static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private MissionService missionService;


    @RequestMapping("/mission")
    @CrossOrigin(origins = crossOriginUrl)
    public List<Mission> getAllMissions() {
        List<Mission> lp=null;
        try {
            lp=missionService.getMission();
        } catch (GetListMissionException e) {
            System.out.println(e.getMessage());
        }
        return lp;
    }

    @RequestMapping("/mission/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public Mission getMissionId(@PathVariable int id) {
        Mission p=null;
        try {
            p= missionService.getMission(id);
        } catch (GetMissionByIdException e) {

            System.out.println(e.getMessage());
        }
        return p;
    }

    @RequestMapping(method = RequestMethod.POST,value="/mission")
    @CrossOrigin(origins = crossOriginUrl)
    public void addMission(@RequestBody Mission mission) {

        try {
            missionService.addMission(mission);
        } catch (AddMissionException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT,value="/mission/{id}")
    public void editMission(@RequestBody Mission mission, @PathVariable int id) {
        try {
            missionService.editMission(mission, id);
        } catch (EditMissionException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/mission/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public void deleteMission(@PathVariable int id) {
        try {
            missionService.deleteMission(id);
        } catch (DeleteMissionException e) {
            System.out.println(e.getMessage());
        }
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllMission")
    //CrossOrigin(origins = crossOriginUrl)
    public void deleteAllMission() {
        try {
            missionService.deleteAllMission();
        } catch (DeleteAllException e) {
            System.out.println(e.getMessage());
        }
    }

    public MissionService getMissionService() {
        return missionService;
    }

    public void setMissionService(MissionService missionService) {
        this.missionService = missionService;
    }

}
