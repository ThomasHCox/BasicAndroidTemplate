package com.allie.templateapplication.interfaces;

import com.allie.templateapplication.model.Advertisement;
import com.allie.templateapplication.model.Employee;

/**
 * Created by tcox on 10/19/17.
 */

public interface IListener {

    void onEmployeeListener(Employee employee);

    void onAdListener(Advertisement advertisement);
}
