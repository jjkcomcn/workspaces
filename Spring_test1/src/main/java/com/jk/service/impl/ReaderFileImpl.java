package com.jk.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.jk.codemapper.CodeMapper;

@Service
public class ReaderFileImpl<E> implements CodeMapper {

    @Override
    public Object getQ0101() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getDBFromText(Class clazz, String fileUrl, String splitstr, String[] names) {
        ArrayList<Object> array = new ArrayList<Object>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File(fileUrl)), "UTF-8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(splitstr);
                Object newInstance = clazz.newInstance();
                for (int i = 0; i < split.length; i++) {
                    clazz.getMethod("set" + names[i], String.class).invoke(newInstance, split[i]);
                }
                array.add(newInstance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

}
