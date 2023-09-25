package bootcamp.socialMeli.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ProductOrderListEnum {
    @JsonProperty("date_asc")
    dateAsc,
    @JsonProperty("date_desc")
    dateDesc
}
