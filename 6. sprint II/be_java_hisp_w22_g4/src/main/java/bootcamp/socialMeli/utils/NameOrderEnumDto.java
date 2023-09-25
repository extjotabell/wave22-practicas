package bootcamp.socialMeli.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum NameOrderEnumDto {
    @JsonProperty("name_asc")
    nameAsc,
    @JsonProperty("name_desc")
    nameDesc
}
