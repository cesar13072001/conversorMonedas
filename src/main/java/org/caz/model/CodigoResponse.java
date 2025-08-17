package org.caz.model;

import java.util.ArrayList;

public class CodigoResponse {

    public String result;
    public String documentation;
    public String terms_of_use;
    public ArrayList<ArrayList<String>> supported_codes;


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public void setTerms_of_use(String terms_of_use) {
        this.terms_of_use = terms_of_use;
    }

    public ArrayList<ArrayList<String>> getSupported_codes() {
        return supported_codes;
    }

    public void setSupported_codes(ArrayList<ArrayList<String>> supported_codes) {
        this.supported_codes = supported_codes;
    }
}
