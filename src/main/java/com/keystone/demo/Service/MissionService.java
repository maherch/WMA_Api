package com.keystone.demo.Service;

import com.keystone.demo.Entity.Mission;
import com.keystone.demo.Repository.MissionRepository;
import com.keystone.demo.exceptionMission.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {

    @Autowired
    private MissionRepository missionRepository;

    public boolean isExiste(int id) {
        return missionRepository.existsById(id);
    }

    public List<Mission> getMission() throws GetListMissionException {
        List<Mission> lp =null;
        lp = (List<Mission>) missionRepository.findAll();
        if (lp.isEmpty() || lp.equals(null))
            throw new GetListMissionException("Erreur : Liste mission est vide ");
        else
            return lp;
    }

    public Mission getMission(int id) throws GetMissionByIdException {
        if(!isExiste(id))
            throw new GetMissionByIdException("Erreur : ID incorrect !");
        else
            return missionRepository.findById(id).get();
    }

    public void addMission(Mission mission) throws AddMissionException {

        missionRepository.save(mission);


    }

    public void editMission(Mission mission, int id) throws EditMissionException {
        if(!isExiste(id))
            throw new EditMissionException("Erreur : ID incorrect !");
        else {
            missionRepository.deleteById(id);
            missionRepository.save(mission);
        }
    }

    public void deleteMission(int id) throws DeleteMissionException {
        if(!isExiste(id))
            throw new DeleteMissionException("Erreur : ID incorrect");
        else
            missionRepository.deleteById(id);
    }

    public void deleteAllMission() throws DeleteAllException {
        if(missionRepository.count()==0)
            throw new DeleteAllException("Erreur : il n'y a pas des missions pour effacer !" );
        else
            missionRepository.deleteAll();
    }

}
