package com.rest_api_java.api.manage_files;


import com.rest_api_java.api.model.County;
import com.rest_api_java.api.utils.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageCounties {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------

    private static final String URL_COUNTIES = "D:\\AAAAA ce invat eu\\Stanciu_Ionela-Melania_api\\test-java-fullstack-county.csv";

    //----------------------------------------------------------------------
    //Methods
    //----------------------------------------------------------------------

    public List<County> readCounties() throws IOException {

        List<County> counties = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(URL_COUNTIES)));
        String nl;
        br.readLine();
        while ((nl = br.readLine()) != null) {
            String[] words = nl.split(",");
            counties.add(new County(Utils.parseStringToInteger(words[0]), Utils.cleanString(words[1]), Utils.cleanString(words[2])));
        }
        return counties;
    }

}
