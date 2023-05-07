package com.example.domain.command.impl.company;

import com.example.domain.command.Command;
import com.example.domain.message.Message;
import com.example.domain.service.CompanyService;
import com.example.domain.service.exception.ServiceException;
import com.example.domain.service.factory.ServiceFactory;
import entity.Company;

import java.util.List;

public class GetAllCompaniesCommand implements Command {

    private CompanyService companyService = ServiceFactory.getInstance().getCompanyService();

    @Override
    public Message execute(Message request) {
        Message response = new Message();
        try {
            List<Company> companies = companyService.getAllCompanies();
            response.add("companies", companies);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }

        return response;
    }
}