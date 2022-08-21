package tech.ineb.lib.common.entities.utils;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsonorg.JsonOrgModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.jooq.*;
import org.jooq.conf.ParamType;
import org.jooq.impl.DSL;
import org.json.JSONObject;

import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Types;
import java.util.Objects;

public class PostgresJSONJsonObjectBinding implements Binding<JSON, JSONObject> {
  private static final JsonMapper MAPPER;

  static {
    MAPPER = JsonMapper.builder()
        .addModule(new JavaTimeModule())
        .addModule(new JsonOrgModule())
        .build();
  }

  // The converter does all the work
  @Override
  public Converter<JSON, JSONObject> converter() {
    return new Converter<JSON, JSONObject>() {
      @Override
      public JSONObject from(JSON t) {
        return t == null ? null : new JSONObject(t.data());
      }

      @SneakyThrows @Override
      public JSON to(JSONObject u) {
        return u == null ? null : JSON.valueOf(MAPPER.writeValueAsString(u));
      }

      @Override
      public Class<JSON> fromType() {
        return JSON.class;
      }

      @Override
      public Class<JSONObject> toType() {
        return JSONObject.class;
      }
    };
  }

  // Rending a bind variable for the binding context's value and casting it to the json type
  @Override
  public void sql(BindingSQLContext<JSONObject> ctx) {
    // Depending on how you generate your SQL, you may need to explicitly distinguish
    // between jOOQ generating bind variables or inlined literals.
    if (ctx.render().paramType() == ParamType.INLINED)
      ctx.render().visit(DSL.inline(ctx.convert(converter()).value())).sql("::json");
    else
      ctx.render().sql("?::json");
  }

  // Registering VARCHAR types for JDBC CallableStatement OUT parameters
  @Override
  public void register(BindingRegisterContext<JSONObject> ctx) throws SQLException {
    ctx.statement().registerOutParameter(ctx.index(), Types.VARCHAR);
  }

  // Converting the JsonElement to a String value and setting that on a JDBC PreparedStatement
  @Override
  public void set(BindingSetStatementContext<JSONObject> ctx) throws SQLException {
    ctx.statement().setString(ctx.index(), Objects.toString(ctx.convert(converter()).value(), null));
  }

  // Getting a String value from a JDBC ResultSet and converting that to a JsonElement
  @Override
  public void get(BindingGetResultSetContext<JSONObject> ctx) throws SQLException {
    ctx.convert(converter()).value(JSON.valueOf(ctx.resultSet().getString(ctx.index())));
  }

  // Getting a String value from a JDBC CallableStatement and converting that to a JsonElement
  @Override
  public void get(BindingGetStatementContext<JSONObject> ctx) throws SQLException {
    ctx.convert(converter()).value(JSON.valueOf(ctx.statement().getString(ctx.index())));
  }

  // Setting a value on a JDBC SQLOutput (useful for Oracle OBJECT types)
  @Override
  public void set(BindingSetSQLOutputContext<JSONObject> ctx) throws SQLException {
    throw new SQLFeatureNotSupportedException();
  }

  // Getting a value from a JDBC SQLInput (useful for Oracle OBJECT types)
  @Override
  public void get(BindingGetSQLInputContext<JSONObject> ctx) throws SQLException {
    throw new SQLFeatureNotSupportedException();
  }
}
