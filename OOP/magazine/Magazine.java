package OOP.magazine;

import java.time.LocalDate;

import shared.NumberUtil;
import shared.StringUtil;

public class Magazine {
    private String title;
    private String publisher;
    private int issueNumber;
    private int publicationYear;
    StringUtil shared = new StringUtil();
    NumberUtil numberUtil = new NumberUtil();

    public Magazine(String title, String publisher, int issueNumber, int publicationYear){
        setTitle(title);
        setPublisher(publisher);
        setIssueNumber(issueNumber);
        setPublicationYear(publicationYear);
    }

    public Magazine(Magazine soure){
        this.title = soure.title;
        this.publisher = soure.publisher;
        this.issueNumber = soure.issueNumber;
        this.publicationYear = soure.publicationYear;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if(shared.isNullOrBlank(title)){
            throw new IllegalArgumentException("Title cannot be null or blank!");
        }

        this.title = title;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        if(shared.isNullOrBlank(publisher)){
            throw new IllegalArgumentException("Publisher cannot be null or blank!");
        }

        this.publisher = publisher;
    }

    public int getIssueNumber() {
        return this.issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        if(issueNumber <= 0){
            throw new IllegalArgumentException("Issue number must be greater than 0!");
        }

        this.issueNumber = issueNumber;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public void setPublicationYear(int publicationYear) { 
        int currentYear = LocalDate.now().getYear();

        if(!numberUtil.isInsidOfValidRange(publicationYear, 0, currentYear)){
            throw new IllegalArgumentException("Issue number must be greater than 0 and less than " + currentYear + "!");
        }

        this.publicationYear = publicationYear;
    }
}
