package com.rest_api_java.api.manage_files;

import com.rest_api_java.api.model.Locality;
import com.rest_api_java.api.utils.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageLocalities {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------

    private static final String URL_LOCALITIES = "D:\\AAAAA ce invat eu\\Stanciu_Ionela-Melania_api\\test-java-fullstack-locality.csv";

    //----------------------------------------------------------------------
    //Methods
    //----------------------------------------------------------------------

    public List<Locality> readLocalities() throws IOException {

        List<Locality> localities = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(URL_LOCALITIES)));
        String nl;
        br.readLine();
        while ((nl = br.readLine()) != null) {
            String[] words = nl.split(",");
            localities.add(new Locality(Utils.parseStringToInteger(words[0]), Utils.cleanString(words[1]), Utils.cleanString(words[2])));
        }
        return localities;
    }

}
