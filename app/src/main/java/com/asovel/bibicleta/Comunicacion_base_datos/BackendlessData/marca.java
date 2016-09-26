package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessData;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class marca
{
  private java.util.Date updated;
  private String tipo_de_via;
  private String email;
  private String ownerId;
  private String objectId;
  private Integer codigo_postal;
  private String pagina_web;
  private String telefono;
  private Integer numero;
  private String pais;
  private String nombre_marca;
  private String ciudad;
  private String logo;
  private String direccion;
  private java.util.Date created;
  private java.util.List<eBike> modelo_eBike;
  private java.util.List<fabricante> nombre_fabricante;
  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getTipo_de_via()
  {
    return tipo_de_via;
  }

  public void setTipo_de_via( String tipo_de_via )
  {
    this.tipo_de_via = tipo_de_via;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail( String email )
  {
    this.email = email;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public Integer getCodigo_postal()
  {
    return codigo_postal;
  }

  public void setCodigo_postal( Integer codigo_postal )
  {
    this.codigo_postal = codigo_postal;
  }

  public String getPagina_web()
  {
    return pagina_web;
  }

  public void setPagina_web( String pagina_web )
  {
    this.pagina_web = pagina_web;
  }

  public String getTelefono()
  {
    return telefono;
  }

  public void setTelefono( String telefono )
  {
    this.telefono = telefono;
  }

  public Integer getNumero()
  {
    return numero;
  }

  public void setNumero( Integer numero )
  {
    this.numero = numero;
  }

  public String getPais()
  {
    return pais;
  }

  public void setPais( String pais )
  {
    this.pais = pais;
  }

  public String getNombre_marca()
  {
    return nombre_marca;
  }

  public void setNombre_marca( String nombre_marca )
  {
    this.nombre_marca = nombre_marca;
  }

  public String getCiudad()
  {
    return ciudad;
  }

  public void setCiudad( String ciudad )
  {
    this.ciudad = ciudad;
  }

  public String getLogo()
  {
    return logo;
  }

  public void setLogo( String logo )
  {
    this.logo = logo;
  }

  public String getDireccion()
  {
    return direccion;
  }

  public void setDireccion( String direccion )
  {
    this.direccion = direccion;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.List<eBike> getModelo_eBike()
  {
    return modelo_eBike;
  }

  public void setModelo_eBike( java.util.List<eBike> modelo_eBike )
  {
    this.modelo_eBike = modelo_eBike;
  }

  public java.util.List<fabricante> getNombre_fabricante()
  {
    return nombre_fabricante;
  }

  public void setNombre_fabricante( java.util.List<fabricante> nombre_fabricante )
  {
    this.nombre_fabricante = nombre_fabricante;
  }

                                                    
  public marca save()
  {
    return Backendless.Data.of( marca.class ).save( this );
  }

  public Future<marca> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<marca> future = new Future<marca>();
      Backendless.Data.of( marca.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<marca> callback )
  {
    Backendless.Data.of( marca.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( marca.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( marca.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( marca.class ).remove( this, callback );
  }

  public static marca findById( String id )
  {
    return Backendless.Data.of( marca.class ).findById( id );
  }

  public static Future<marca> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<marca> future = new Future<marca>();
      Backendless.Data.of( marca.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<marca> callback )
  {
    Backendless.Data.of( marca.class ).findById( id, callback );
  }

  public static marca findFirst()
  {
    return Backendless.Data.of( marca.class ).findFirst();
  }

  public static Future<marca> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<marca> future = new Future<marca>();
      Backendless.Data.of( marca.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<marca> callback )
  {
    Backendless.Data.of( marca.class ).findFirst( callback );
  }

  public static marca findLast()
  {
    return Backendless.Data.of( marca.class ).findLast();
  }

  public static Future<marca> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<marca> future = new Future<marca>();
      Backendless.Data.of( marca.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<marca> callback )
  {
    Backendless.Data.of( marca.class ).findLast( callback );
  }

  public static BackendlessCollection<marca> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( marca.class ).find( query );
  }

  public static Future<BackendlessCollection<marca>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<marca>> future = new Future<BackendlessCollection<marca>>();
      Backendless.Data.of( marca.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<marca>> callback )
  {
    Backendless.Data.of( marca.class ).find( query, callback );
  }
}