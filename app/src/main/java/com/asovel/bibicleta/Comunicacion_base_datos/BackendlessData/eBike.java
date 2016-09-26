package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessData;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class eBike
{
  private String suspension;
  private String tipo_sensor;
  private java.util.Date created;
  private String tipo_de_uso;
  private String tipo_cuadro;
  private String precio;
  private String ubicacion_motor;
  private String puntos_de_venta;
  private String peso_total;
  private String material_del_cuadro;
  private String velocidades;
  private String tipo_display;
  private String foto;
  private String autonomia;
  private String pagina_web;
  private String ownerId;
  private String modelo;
  private String objectId;
  private String tamano_ruedas;
  private java.util.Date updated;
  private java.util.List<tiendas> marca;
  public String getSuspension()
  {
    return suspension;
  }

  public void setSuspension( String suspension )
  {
    this.suspension = suspension;
  }

  public String getTipo_sensor()
  {
    return tipo_sensor;
  }

  public void setTipo_sensor( String tipo_sensor )
  {
    this.tipo_sensor = tipo_sensor;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getTipo_de_uso()
  {
    return tipo_de_uso;
  }

  public void setTipo_de_uso( String tipo_de_uso )
  {
    this.tipo_de_uso = tipo_de_uso;
  }

  public String getTipo_cuadro()
  {
    return tipo_cuadro;
  }

  public void setTipo_cuadro( String tipo_cuadro )
  {
    this.tipo_cuadro = tipo_cuadro;
  }

  public String getPrecio()
  {
    return precio;
  }

  public void setPrecio( String precio )
  {
    this.precio = precio;
  }

  public String getUbicacion_motor()
  {
    return ubicacion_motor;
  }

  public void setUbicacion_motor( String ubicacion_motor )
  {
    this.ubicacion_motor = ubicacion_motor;
  }

  public String getPuntos_de_venta()
  {
    return puntos_de_venta;
  }

  public void setPuntos_de_venta( String puntos_de_venta )
  {
    this.puntos_de_venta = puntos_de_venta;
  }

  public String getPeso_total()
  {
    return peso_total;
  }

  public void setPeso_total( String peso_total )
  {
    this.peso_total = peso_total;
  }

  public String getMaterial_del_cuadro()
  {
    return material_del_cuadro;
  }

  public void setMaterial_del_cuadro( String material_del_cuadro )
  {
    this.material_del_cuadro = material_del_cuadro;
  }

  public String getVelocidades()
  {
    return velocidades;
  }

  public void setVelocidades( String velocidades )
  {
    this.velocidades = velocidades;
  }

  public String getTipo_display()
  {
    return tipo_display;
  }

  public void setTipo_display( String tipo_display )
  {
    this.tipo_display = tipo_display;
  }

  public String getFoto()
  {
    return foto;
  }

  public void setFoto( String foto )
  {
    this.foto = foto;
  }

  public String getAutonomia()
  {
    return autonomia;
  }

  public void setAutonomia( String autonomia )
  {
    this.autonomia = autonomia;
  }

  public String getPagina_web()
  {
    return pagina_web;
  }

  public void setPagina_web( String pagina_web )
  {
    this.pagina_web = pagina_web;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getModelo()
  {
    return modelo;
  }

  public void setModelo( String modelo )
  {
    this.modelo = modelo;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getTamano_ruedas()
  {
    return tamano_ruedas;
  }

  public void setTamano_ruedas( String tamano_ruedas )
  {
    this.tamano_ruedas = tamano_ruedas;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public java.util.List<tiendas> getMarca()
  {
    return marca;
  }

  public void setMarca( java.util.List<tiendas> marca )
  {
    this.marca = marca;
  }

                                                    
  public eBike save()
  {
    return Backendless.Data.of( eBike.class ).save( this );
  }

  public Future<eBike> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<eBike> future = new Future<eBike>();
      Backendless.Data.of( eBike.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<eBike> callback )
  {
    Backendless.Data.of( eBike.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( eBike.class ).remove( this );
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
      Backendless.Data.of( eBike.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( eBike.class ).remove( this, callback );
  }

  public static eBike findById( String id )
  {
    return Backendless.Data.of( eBike.class ).findById( id );
  }

  public static Future<eBike> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<eBike> future = new Future<eBike>();
      Backendless.Data.of( eBike.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<eBike> callback )
  {
    Backendless.Data.of( eBike.class ).findById( id, callback );
  }

  public static eBike findFirst()
  {
    return Backendless.Data.of( eBike.class ).findFirst();
  }

  public static Future<eBike> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<eBike> future = new Future<eBike>();
      Backendless.Data.of( eBike.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<eBike> callback )
  {
    Backendless.Data.of( eBike.class ).findFirst( callback );
  }

  public static eBike findLast()
  {
    return Backendless.Data.of( eBike.class ).findLast();
  }

  public static Future<eBike> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<eBike> future = new Future<eBike>();
      Backendless.Data.of( eBike.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<eBike> callback )
  {
    Backendless.Data.of( eBike.class ).findLast( callback );
  }

  public static BackendlessCollection<eBike> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( eBike.class ).find( query );
  }

  public static Future<BackendlessCollection<eBike>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<eBike>> future = new Future<BackendlessCollection<eBike>>();
      Backendless.Data.of( eBike.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<eBike>> callback )
  {
    Backendless.Data.of( eBike.class ).find( query, callback );
  }
}