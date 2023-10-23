package br.guilherme.bellini.msemployees.domain.service.domain.common;

import br.guilherme.bellini.msemployees.domain.entity.Employees;

public class EmployeesConstants {

    public static final Employees employees = new Employees(1L, "Guilherme", "01234567890", 30);
    public static final Employees invalid_employees = new Employees(null, " ", " ", null);
}
