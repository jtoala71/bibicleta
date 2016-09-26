package com.asovel.bibicleta.Comunicacion_base_datos.Backendlesscumple;

import java.util.List;

/**
 * Created by emilio on 17/09/2016.
 */
public class BackendlessResponse {

    private String offset;
    private List<Bicis> data;
    private String nextPage;
    private float totalObjects;

    public BackendlessResponse(String offset, List<Bicis> data, String nextPage, float totalObjects) {
        this.offset = offset;
        this.data = data;
        this.nextPage = nextPage;
        this.totalObjects = totalObjects;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public List<Bicis> getData() {
        return data;
    }

    public void setData(List<Bicis> data) {
        this.data = data;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public float getTotalObjects() {
        return totalObjects;
    }

    public void setTotalObjects(float totalObjects) {
        this.totalObjects = totalObjects;
    }



}
