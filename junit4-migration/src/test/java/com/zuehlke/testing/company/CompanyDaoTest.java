package com.zuehlke.testing.company;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class CompanyDaoTest {

    private CompanyDao dao = new CompanyDao();

    @Rule
    public CompanyResource companyResource = new CompanyResource();

    @Test
    public void find() {
        // arrange
        Company expected = companyResource.createCompany("Zuehlke Engineering AG");
        // act
        Company result = dao.find(expected.getName());
        // assert
        assertEquals(expected.getName(), result.getName());
    }

    private class CompanyResource extends ExternalResource {

        private CompanyDao dao = new CompanyDao();
        private Collection<Company> companies = new LinkedList<Company>();

        public Company createCompany(String name) {
            final Company company = new Company(name);
            dao.save(company);
            companies.add(company);
            return company;
        }

        @Override
        protected void after() {
            for (Company company : companies) {
                dao.delete(company);
            }
            super.after();
        }

    }
}
