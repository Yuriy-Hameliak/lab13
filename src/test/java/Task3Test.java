

import org.junit.jupiter.api.Test;

import kb13.task3.BrandFetchReader;
import kb13.task3.Company;
import kb13.task3.CompanyReaderFacade;
import kb13.task3.PDLReader;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class Task3Test {

    @Test
    void brandFetchReaderTest() {
        BrandFetchReader reader = mock(BrandFetchReader.class);
        Company expectedCompany = new Company();
        expectedCompany.setName("Test Company");
        expectedCompany.setDescription("This is a test company.");
        expectedCompany.setLogo("https://testcompany.com/logo.png");

        when(reader.fetch("testcompany.com")).thenReturn(expectedCompany);

        Company actualCompany = reader.fetch("testcompany.com");
        assertEquals(expectedCompany.getName(), actualCompany.getName());
        assertEquals(expectedCompany.getDescription(), actualCompany.getDescription());
        assertEquals(expectedCompany.getLogo(), actualCompany.getLogo());
    }

    @Test
    void pdlReaderTest() {
        PDLReader reader = mock(PDLReader.class);
        Company expectedCompany = new Company();
        expectedCompany.setName("Test Company");
        expectedCompany.setDescription("This is a test company.");
        expectedCompany.setLogo("https://testcompany.com/logo.png");

        when(reader.fetch("testcompany.com")).thenReturn(expectedCompany);

        Company actualCompany = reader.fetch("testcompany.com");
        assertEquals(expectedCompany.getName(), actualCompany.getName());
        assertEquals(expectedCompany.getDescription(), actualCompany.getDescription());
        assertEquals(expectedCompany.getLogo(), actualCompany.getLogo());
    }

    @Test
    void companyReaderFacadeTest() {
        PDLReader mockPDLReader = mock(PDLReader.class);
        BrandFetchReader mockBrandFetchReader = mock(BrandFetchReader.class);

        Company pdlCompany = new Company();
        pdlCompany.setName("PDL Company");
        pdlCompany.setDescription("PDL Description");
        pdlCompany.setLogo(null);

        Company brandFetchCompany = new Company();
        brandFetchCompany.setName(null);
        brandFetchCompany.setDescription("BrandFetch Description");
        brandFetchCompany.setLogo("https://brandfetch.com/logo.png");

        when(mockPDLReader.fetch("testcompany.com")).thenReturn(pdlCompany);
        when(mockBrandFetchReader.fetch("testcompany.com")).thenReturn(brandFetchCompany);

        CompanyReaderFacade facade = new CompanyReaderFacade();
        facade.reader1 = mockPDLReader;
        facade.reader2 = mockBrandFetchReader;

        Company result = facade.readCompany("testcompany.com");

        assertEquals("PDL Company", result.getName());
        assertEquals("PDL Description", result.getDescription());
        assertEquals("https://brandfetch.com/logo.png", result.getLogo());
    }

    @Test
    void mergeCompaniesTest() {
        CompanyReaderFacade facade = new CompanyReaderFacade();

        Company company1 = new Company();
        company1.setName("Company1");
        company1.setDescription("Description1");
        company1.setLogo(null);

        Company company2 = new Company();
        company2.setName(null);
        company2.setDescription(null);
        company2.setLogo("Logo2");

        Company result = facade.mergeCompanies(company1, company2);

        assertEquals("Company1", result.getName());
        assertEquals("Description1", result.getDescription());
        assertEquals("Logo2", result.getLogo());
    }

    @Test
    void companyTest() {
        Company company = new Company();
        company.setName("Test Company");
        company.setDescription("Test Description");
        company.setLogo("Test Logo");

        assertEquals("Test Company", company.getName());
        assertEquals("Test Description", company.getDescription());
        assertEquals("Test Logo", company.getLogo());
    }
}
