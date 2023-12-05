package com.CSC340.RMSproj.Engineer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceEngineerService {

    @Autowired
    private RaceEngineerRepo repo;
    public List<RaceEngineer> getAllTracks(){
        return repo.findAll();
    }

    public String[] calculateStrategy(RaceEngineer track, int laps, int compounds) {
    double mpg = 5;
    double tankSize = 20;
    int lapsOnOneTank = (int) (tankSize * mpg);
    int numOfStops = laps / lapsOnOneTank;
    String[] strategies = new String[2];
    switch(track.getSurface())
    {
        case "abrasive":
            switch (compounds)
            {
                case 1:
                    if(numOfStops == 0)
                    {
                        strategies[0] = "No pit stop required. Tell driver to be patient.";
                        strategies[1] = "Pit on lap " + laps / 2 + ". Tell driver to be aggressive.";
                    }
                    else
                    {
                        strategies[0] = "Pit every " + laps / (numOfStops + 1) + " laps. Tell driver to be patient.";
                        strategies[1] = "Pit every " + laps / (numOfStops + 2) + " laps. Tell driver to be aggressive.";
                    }
                    break;
                case 2:
                    if(numOfStops == 0)
                    {
                        if(laps < (lapsOnOneTank) + (int) (track.getLength() * 10))
                        {
                            strategies[0] = "No pit stop required. Start on softer compound. Tell driver to be patient.";
                        }
                        else
                        {
                            strategies[0] = "No pit stop required. Start on harder compound. Tell driver to be aggressive.";
                        }
                        strategies[1] = "Pit on lap " + laps / 2 + ". Start on softer compound. Tell driver to be aggressive.";
                    }
                    else
                    {
                        if(laps < (lapsOnOneTank * (numOfStops)) + (int) (track.getLength() * 10))
                        {
                            strategies[0] = "Pit every " + laps / (numOfStops + 1) + " laps. Start on softer compound. Tell driver to be patient.";
                        }
                        else
                        {
                            strategies[0] = "Pit every " + laps / (numOfStops + 1) + " laps. Start on harder compound. Tell driver to be aggressive.";
                        }
                        strategies[1] = "Pit every " + laps / (numOfStops + 2) + " laps. Start on softer compound. Tell driver to be aggressive.";
                    }
                    break;
                case 3:
                    if(numOfStops == 0)
                    {
                        if(laps < (lapsOnOneTank) + (int) (track.getLength() * 10))
                        {
                            strategies[0] = "No pit stop required. Start on medium compound. Tell driver to be patient.";
                        }
                        else
                        {
                            strategies[0] = "No pit stop required. Start on hard compound. Tell driver to be aggressive.";
                        }
                        strategies[1] = "Pit on lap " + laps / 2 + ". Start on soft compound. Tell driver to be aggressive.";
                    }
                    else
                    {
                        if(laps < (lapsOnOneTank * (numOfStops)) + (int) (track.getLength() * 10))
                        {
                            strategies[0] = "Pit every " + laps / (numOfStops + 1) + " laps. Start on medium compound. Tell driver to be patient.";
                        }
                        else
                        {
                            strategies[0] = "Pit every " + laps / (numOfStops + 1) + " laps. Start on hard compound. Tell driver to be aggressive.";
                        }
                        strategies[1] = "Pit every " + laps / (numOfStops + 2) + " laps. Start on soft compound. Tell driver to be aggressive.";
                    }
                    break;
            }
            break;
        case "smooth":
            switch (compounds)
            {
                case 1:
                    if(numOfStops == 0)
                    {
                        strategies[0] = "No pit stop required. Tell driver to be aggressive.";
                        strategies[1] = "Pit on lap " + laps / 2 + ". Tell driver to be aggressive.";
                    }
                    else
                    {
                        strategies[0] = "Pit every " + laps / (numOfStops + 1) + " laps. Tell driver to be aggressive.";
                        strategies[1] = "Pit every " + laps / (numOfStops + 2) + " laps. Tell driver to be aggressive.";
                    }
                    break;
                case 2:
                    if(numOfStops == 0)
                    {
                        strategies[0] = "No pit stop required. Start on softer compound. Tell driver to be aggressive.";
                        strategies[1] = "No pit stop required. Start on harder compound. Tell driver to be aggressive.";
                    }
                    else
                    {
                        strategies[0] = "Pit every " + laps / (numOfStops + 1) + " laps. Start on softer compound. Tell driver to be aggressive.";
                        strategies[0] = "Pit every " + laps / (numOfStops + 1) + " laps. Start on harder compound. Tell driver to be aggressive.";
                        strategies[1] = "Pit every " + laps / (numOfStops + 2) + " laps. Start on softer compound. Tell driver to be aggressive.";
                    }
                    break;
                case 3:
                    if(numOfStops == 0)
                    {
                        if(laps < (lapsOnOneTank) + (int) (track.getLength() * 10))
                        {
                            strategies[0] = "No pit stop required. Start on soft compound. Tell driver to be patient.";
                        }
                        else
                        {
                            strategies[0] = "No pit stop required. Start on medium compound. Tell driver to be aggressive.";
                        }
                        strategies[1] = "Pit on lap " + laps / 2 + ". Start on soft compound. Tell driver to be aggressive.";
                    }
                    else
                    {
                        if(laps < (lapsOnOneTank * (numOfStops)) + (int) (track.getLength() * 10))
                        {
                            strategies[0] = "Pit every " + laps / (numOfStops + 1) + " laps. Start on soft compound. Tell driver to be patient.";
                        }
                        else
                        {
                            strategies[0] = "Pit every " + laps / (numOfStops + 1) + " laps. Start on medium compound. Tell driver to be aggressive.";
                        }
                        strategies[1] = "Pit every " + laps / (numOfStops + 2) + " laps. Start on soft compound. Tell driver to be aggressive.";
                    }
                    break;
            }
            break;
    }
    return strategies;
    }
}
