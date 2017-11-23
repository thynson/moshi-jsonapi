package moe.banana.jsonapi2;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.io.Serializable;

import static moe.banana.jsonapi2.MoshiHelper.*;

public class Error implements Serializable {

    private String id;
    private String status;
    private String code;
    private String title;
    private String detail;

    private JsonBuffer source;
    private JsonBuffer meta;
    private JsonBuffer links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public JsonBuffer getMeta() {
        return meta;
    }

    public JsonBuffer getLinks() {
        return links;
    }

    public void setMeta(JsonBuffer meta) {
        this.meta = meta;
    }

    public void setLinks(JsonBuffer links) {
        this.links = links;
    }

    public JsonBuffer getSource() {
        return source;
    }

    public void setSource(JsonBuffer source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Error{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Error error = (Error) o;

        if (id != null ? !id.equals(error.id) : error.id != null) return false;
        if (status != null ? !status.equals(error.status) : error.status != null) return false;
        if (code != null ? !code.equals(error.code) : error.code != null) return false;
        if (title != null ? !title.equals(error.title) : error.title != null) return false;
        return detail != null ? detail.equals(error.detail) : error.detail == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }

    static class Adapter extends JsonAdapter<Error> {

        JsonAdapter<JsonBuffer> jsonBufferJsonAdapter;

        public Adapter(Moshi moshi) {
            jsonBufferJsonAdapter = moshi.adapter(JsonBuffer.class);
        }

        @Override
        public Error fromJson(JsonReader reader) throws IOException {
            Error err = new Error();
            reader.beginObject();
            while (reader.hasNext()) {
                switch (reader.nextName()) {
                    case "id":
                        err.setId(nextNullableString(reader));
                        break;
                    case "status":
                        err.setStatus(nextNullableString(reader));
                        break;
                    case "code":
                        err.setCode(nextNullableString(reader));
                        break;
                    case "title":
                        err.setTitle(nextNullableString(reader));
                        break;
                    case "detail":
                        err.setDetail(nextNullableString(reader));
                        break;
                    case "source":
                        err.setSource(nextNullableObject(reader, jsonBufferJsonAdapter));
                        break;
                    case "meta":
                        err.setMeta(nextNullableObject(reader, jsonBufferJsonAdapter));
                        break;
                    case "links":
                        err.setLinks(nextNullableObject(reader, jsonBufferJsonAdapter));
                        break;
                    default:
                        reader.skipValue();
                        break;
                }
            }
            reader.endObject();
            return err;
        }

        @Override
        public void toJson(JsonWriter writer, Error value) throws IOException {
            writer.beginObject();
            writer.name("id").value(value.getId());
            writer.name("status").value(value.getStatus());
            writer.name("code").value(value.getCode());
            writer.name("title").value(value.getTitle());
            writer.name("detail").value(value.getDetail());
            writeNullable(writer, jsonBufferJsonAdapter, "source", value.getSource());
            writeNullable(writer, jsonBufferJsonAdapter, "meta", value.getMeta());
            writeNullable(writer, jsonBufferJsonAdapter, "links", value.getLinks());
            writer.endObject();
        }
    }

}
