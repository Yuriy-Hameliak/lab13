package kb13.task3;

public class CompanyReaderFacade {

    public PDLReader reader1;
    public BrandFetchReader reader2;

    public CompanyReaderFacade() {
        reader1 = new PDLReader();
        reader2 = new BrandFetchReader();
    }

    public Company readCompany(String companyName) {
        Company company1 = null;
        Company company2 = null;

        try {
            company1 = reader1.fetch(companyName);
        } catch (Exception e) {
            System.err.println("PDLReader failed: " + e.getMessage());
        }

        try {
            company2 = reader2.fetch(companyName);
        } catch (Exception e) {
            System.err.println("BrandFetchReader failed: " + e.getMessage());
        }

        return mergeCompanies(company1, company2);
    }

    private String getNonNullValue(String value1, String value2) {
        return (value1 != null && !value1.isEmpty()) ? value1 : value2;
    }
    
    public Company mergeCompanies(Company company1, Company company2) {
        Company result = new Company();
    
        result.setName(getNonNullValue(
            company1 != null ? company1.getName() : null,
            company2 != null ? company2.getName() : null
        ));
    
        result.setDescription(getNonNullValue(
            company1 != null ? company1.getDescription() : null,
            company2 != null ? company2.getDescription() : null
        ));
    
        result.setLogo(getNonNullValue(
            company1 != null ? company1.getLogo() : null,
            company2 != null ? company2.getLogo() : null
        ));
    
        return result;
    }
}