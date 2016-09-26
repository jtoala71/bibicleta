package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessData;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class fabricante
{
  private Integer codigo_postal;
  private String ownerId;
  private String ciudad;
  private String objectId;
  private String pais;
  private java.util.Date updated;
  private String email;
  private String nombre_fabricante;
  private java.util.Date created;
  private Integer numero;
  private String telefono;
  private String tipo_de_via;
  private String direccion;
  private String pagina_web;
  public Integer getCodigo_postal()
  {
    return codigo_postal;
  }

  public void setCodigo_postal( Integer codigo_postal )
  {
    this.codigo_postal = codigo_postal;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getCiudad()
  {
    return ciudad;
  }

  public void setCiudad( String ciudad )
  {
    this.ciudad = ciudad;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getPais()
  {
    return pais;
  }

  public void setPais( String pais )
  {
    this.pais = pais;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail( String email )
  {
    this.email = email;
  }

  public String getNombre_fabricante()
  {
    return nombre_fabricante;
  }

  public void setNombre_fabricante( String nombre_fabricante )
  {
    this.nombre_fabricante = nombre_fabricante;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public Integer getNumero()
  {
    return numero;
  }

  public void setNumero( Integer numero )
  {
    this.numero = numero;
  }

  public String getTelefono()
  {
    return telefono;
  }

  public void setTelefono( String telefono )
  {
    this.telefono = telefono;
  }

  public String getTipo_de_via()
  {
    return tipo_de_via;
  }

  public void setTipo_de_via( String tipo_de_via )
  {
    this.tipo_de_via = tipo_de_via;
  }

  public String getDireccion()
  {
    return direccion;
  }

  public void setDireccion( String direccion )
  {
    this.direccion = direccion;
  }

  public String getPagina_web()
  {
    return pagina_web;
  }

  public void setPagina_web( String pagina_web )
  {
    this.pagina_web = pagina_web;
  }

                                                    
  public fabricante save()
  {
    return Backendless.Data.of( fabricante.class ).save( this );
  }

  public Future<fabricante> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<fabricante> future = new Future<fabricante>();
      Backendless.Data.of( fabricante.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<fabricante> callback )
  {
    Backendless.Data.of( fabricante.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( fabricante.class ).remove( this );
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
      Backendless.Data.of( fabricante.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( fabricante.class ).remove( this, callback );
  }

  public static fabricante findById( String id )
  {
    return Backendless.Data.of( fabricante.class ).findById( id );
  }

  public static Future<fabricante> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<fabricante> future = new Future<fabricante>();
      Backendless.Data.of( fabricante.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<fabricante> callback )
  {
    Backendless.Data.of( fabricante.class ).findById( id, callback );
  }

  public static fabricante findFirst()
  {
    return Backendless.Data.of( fabricante.class ).findFirst();
  }

  public static Future<fabricante> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<fabricante> future = new Future<fabricante>();
      Backendless.Data.of( fabricante.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<fabricante> callback )
  {
    Backendless.Data.of( fabricante.class ).findFirst( callback );
  }

  public static fabricante findLast()
  {
    return Backendless.Data.of( fabricante.class ).findLast();
  }

  public static Future<fabricante> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<fabricante> future = new Future<fabricante>();
      Backendless.Data.of( fabricante.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<fabricante> callback )
  {
    Backendless.Data.of( fabricante.class ).findLast( callback );
  }

  public static BackendlessCollection<fabricante> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( fabricante.class ).find( query );
  }

  public static Future<BackendlessCollection<fabricante>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<fabricante>> future = new Future<BackendlessCollection<fabricante>>();
      Backendless.Data.of( fabricante.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<fabricante>> callback )
  {
    Backendless.Data.of( fabricante.class ).find( query, callback );
  }
}