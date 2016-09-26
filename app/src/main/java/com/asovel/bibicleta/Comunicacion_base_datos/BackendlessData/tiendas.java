package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessData;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class tiendas
{
  private String objectId;
  private String nombre;
  private String ciudad;
  private String pais;
  private String tipo_de_via;
  private String pagina_web;
  private java.util.Date created;
  private java.util.Date updated;
  private String codigo_postal;
  private String email;
  private Integer telefono;
  private String nombre_fabricante;
  private String latitud;
  private Integer numero;
  private String direccion;
  private String longitud;
  private String ownerId;
  public String getObjectId()
  {
    return objectId;
  }

  public String getNombre()
  {
    return nombre;
  }

  public void setNombre( String nombre )
  {
    this.nombre = nombre;
  }

  public String getCiudad()
  {
    return ciudad;
  }

  public void setCiudad( String ciudad )
  {
    this.ciudad = ciudad;
  }

  public String getPais()
  {
    return pais;
  }

  public void setPais( String pais )
  {
    this.pais = pais;
  }

  public String getTipo_de_via()
  {
    return tipo_de_via;
  }

  public void setTipo_de_via( String tipo_de_via )
  {
    this.tipo_de_via = tipo_de_via;
  }

  public String getPagina_web()
  {
    return pagina_web;
  }

  public void setPagina_web( String pagina_web )
  {
    this.pagina_web = pagina_web;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getCodigo_postal()
  {
    return codigo_postal;
  }

  public void setCodigo_postal( String codigo_postal )
  {
    this.codigo_postal = codigo_postal;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail( String email )
  {
    this.email = email;
  }

  public Integer getTelefono()
  {
    return telefono;
  }

  public void setTelefono( Integer telefono )
  {
    this.telefono = telefono;
  }

  public String getNombre_fabricante()
  {
    return nombre_fabricante;
  }

  public void setNombre_fabricante( String nombre_fabricante )
  {
    this.nombre_fabricante = nombre_fabricante;
  }

  public String getLatitud()
  {
    return latitud;
  }

  public void setLatitud( String latitud )
  {
    this.latitud = latitud;
  }

  public Integer getNumero()
  {
    return numero;
  }

  public void setNumero( Integer numero )
  {
    this.numero = numero;
  }

  public String getDireccion()
  {
    return direccion;
  }

  public void setDireccion( String direccion )
  {
    this.direccion = direccion;
  }

  public String getLongitud()
  {
    return longitud;
  }

  public void setLongitud( String longitud )
  {
    this.longitud = longitud;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

                                                    
  public tiendas save()
  {
    return Backendless.Data.of( tiendas.class ).save( this );
  }

  public Future<tiendas> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<tiendas> future = new Future<tiendas>();
      Backendless.Data.of( tiendas.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<tiendas> callback )
  {
    Backendless.Data.of( tiendas.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( tiendas.class ).remove( this );
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
      Backendless.Data.of( tiendas.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( tiendas.class ).remove( this, callback );
  }

  public static tiendas findById( String id )
  {
    return Backendless.Data.of( tiendas.class ).findById( id );
  }

  public static Future<tiendas> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<tiendas> future = new Future<tiendas>();
      Backendless.Data.of( tiendas.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<tiendas> callback )
  {
    Backendless.Data.of( tiendas.class ).findById( id, callback );
  }

  public static tiendas findFirst()
  {
    return Backendless.Data.of( tiendas.class ).findFirst();
  }

  public static Future<tiendas> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<tiendas> future = new Future<tiendas>();
      Backendless.Data.of( tiendas.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<tiendas> callback )
  {
    Backendless.Data.of( tiendas.class ).findFirst( callback );
  }

  public static tiendas findLast()
  {
    return Backendless.Data.of( tiendas.class ).findLast();
  }

  public static Future<tiendas> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<tiendas> future = new Future<tiendas>();
      Backendless.Data.of( tiendas.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<tiendas> callback )
  {
    Backendless.Data.of( tiendas.class ).findLast( callback );
  }

  public static BackendlessCollection<tiendas> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( tiendas.class ).find( query );
  }

  public static Future<BackendlessCollection<tiendas>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<tiendas>> future = new Future<BackendlessCollection<tiendas>>();
      Backendless.Data.of( tiendas.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<tiendas>> callback )
  {
    Backendless.Data.of( tiendas.class ).find( query, callback );
  }
}