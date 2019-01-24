package com.zuehlke.testing.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.Collection;
import java.util.LinkedList;

class CompanyDaoTest {

    private CompanyDao dao = new CompanyDao();

    @RegisterExtension
    CompanyResource companyResource = new CompanyResource();

    @Test
    void find() {
        // arrange
        Company expected = companyResource.createCompany("Zuehlke Engineering AG");
        // act
        Company result = dao.find(expected.getName());
        // assert
        Assertions.assertEquals(expected.getName(), result.getName());
    }

    private class CompanyResource implements AfterEachCallback {

        private CompanyDao dao = new CompanyDao();
        private Collection<Company> companies = new LinkedList<Company>();

        Company createCompany(String name) {
            final Company company = new Company(name);
            dao.save(company);
            companies.add(company);
            return company;
        }

        @Override
        public void afterEach(ExtensionContext context) throws Exception {
            for (Company company : companies) {
                dao.delete(company);
            }
        }
    }
}
