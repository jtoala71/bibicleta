package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.retrieve;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.geo.GeoPoint;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessData.*;
import com.asovel.bibicleta.R;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.DataApplication;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShowEntityActivity extends Activity
{
  private TextView titleView, propertyView, valueView;
  private ListView propertiesView;

  private String type;
  private String table;
  private String property;
  private String relation;
  private String relatedTable;
  private String relatedProperty;

  public void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.entity_properties );

    Intent intent = getIntent();
    type = intent.getStringExtra( "type" );
    property = intent.getStringExtra( "property" );
    relation = intent.getStringExtra( "relation" );
    relatedTable = intent.getStringExtra( "relatedTable" );
    relatedProperty = intent.getStringExtra( "relatedProperty" );

    DataApplication dataApplication = (DataApplication) getApplication();
    table = dataApplication.getChosenTable();

    initUI();
  }

  private void initUI()
  {
    titleView = (TextView) findViewById( R.id.title );
    propertyView = (TextView) findViewById( R.id.propertyHint );
    valueView = (TextView) findViewById( R.id.valueHint );
    propertiesView = (ListView) findViewById( R.id.propertiesList );

    if( type.equals( "Find First" ) )
    {
      titleView.setText( "First " + table );
      initList();
    }
    else if( type.equals( "Find Last" ) )
    {
      titleView.setText( "Last " + table );
      initList();
    }
    else if( type.equals( "Find with Relations" ) )
    {
      titleView.setText( "Find with Relations" );
      propertyView.setText( table + "." + property );
      if( relatedProperty == null )
        valueView.setText( relatedTable );
      else
        valueView.setText( relatedTable + "." + relatedProperty );
      initRelationList();
    }
  }

  private void initList()
  {
    List<HashMap<String, String>> properties = new ArrayList<HashMap<String, String>>();
    if( table.equals( "marca" ) )
    {
      marca marca = (marca) RetrieveRecordActivity.getResultObject();
      HashMap<String, String> property;
      property = new HashMap<String, String>();
      property.put( "property", "updated" );
      property.put( "value", String.valueOf( marca.getUpdated() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "tipo_de_via" );
      property.put( "value", String.valueOf( marca.getTipo_de_via() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "email" );
      property.put( "value", String.valueOf( marca.getEmail() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "ownerId" );
      property.put( "value", String.valueOf( marca.getOwnerId() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "objectId" );
      property.put( "value", String.valueOf( marca.getObjectId() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "codigo_postal" );
      property.put( "value", String.valueOf( marca.getCodigo_postal() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "pagina_web" );
      property.put( "value", String.valueOf( marca.getPagina_web() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "telefono" );
      property.put( "value", String.valueOf( marca.getTelefono() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "numero" );
      property.put( "value", String.valueOf( marca.getNumero() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "pais" );
      property.put( "value", String.valueOf( marca.getPais() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "nombre_marca" );
      property.put( "value", String.valueOf( marca.getNombre_marca() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "ciudad" );
      property.put( "value", String.valueOf( marca.getCiudad() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "logo" );
      property.put( "value", String.valueOf( marca.getLogo() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "direccion" );
      property.put( "value", String.valueOf( marca.getDireccion() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "created" );
      property.put( "value", String.valueOf( marca.getCreated() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "modelo_eBike" );
      property.put( "value", "Related eBike" );
      properties.add( property );
      property = new HashMap<String, String>();
      property.put( "property", "nombre_fabricante" );
      property.put( "value", "Related fabricante" );
      properties.add( property );    }
    else if( table.equals( "eBike" ) )
    {
      eBike eBike = (eBike) RetrieveRecordActivity.getResultObject();
      HashMap<String, String> property;
      property = new HashMap<String, String>();
      property.put( "property", "suspension" );
      property.put( "value", String.valueOf( eBike.getSuspension() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "tipo_sensor" );
      property.put( "value", String.valueOf( eBike.getTipo_sensor() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "created" );
      property.put( "value", String.valueOf( eBike.getCreated() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "tipo_de_uso" );
      property.put( "value", String.valueOf( eBike.getTipo_de_uso() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "tipo_cuadro" );
      property.put( "value", String.valueOf( eBike.getTipo_cuadro() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "precio" );
      property.put( "value", String.valueOf( eBike.getPrecio() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "ubicacion_motor" );
      property.put( "value", String.valueOf( eBike.getUbicacion_motor() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "puntos_de_venta" );
      property.put( "value", String.valueOf( eBike.getPuntos_de_venta() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "peso_total" );
      property.put( "value", String.valueOf( eBike.getPeso_total() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "material_del_cuadro" );
      property.put( "value", String.valueOf( eBike.getMaterial_del_cuadro() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "velocidades" );
      property.put( "value", String.valueOf( eBike.getVelocidades() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "tipo_display" );
      property.put( "value", String.valueOf( eBike.getTipo_display() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "foto" );
      property.put( "value", String.valueOf( eBike.getFoto() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "autonomia" );
      property.put( "value", String.valueOf( eBike.getAutonomia() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "pagina_web" );
      property.put( "value", String.valueOf( eBike.getPagina_web() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "ownerId" );
      property.put( "value", String.valueOf( eBike.getOwnerId() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "modelo" );
      property.put( "value", String.valueOf( eBike.getModelo() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "objectId" );
      property.put( "value", String.valueOf( eBike.getObjectId() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "tamano_ruedas" );
      property.put( "value", String.valueOf( eBike.getTamano_ruedas() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "updated" );
      property.put( "value", String.valueOf( eBike.getUpdated() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "marca" );
      property.put( "value", "Related tiendas" );
      properties.add( property );    }
    else if( table.equals( "tiendas" ) )
    {
      tiendas tiendas = (tiendas) RetrieveRecordActivity.getResultObject();
      HashMap<String, String> property;
      property = new HashMap<String, String>();
      property.put( "property", "objectId" );
      property.put( "value", String.valueOf( tiendas.getObjectId() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "nombre" );
      property.put( "value", String.valueOf( tiendas.getNombre() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "ciudad" );
      property.put( "value", String.valueOf( tiendas.getCiudad() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "pais" );
      property.put( "value", String.valueOf( tiendas.getPais() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "tipo_de_via" );
      property.put( "value", String.valueOf( tiendas.getTipo_de_via() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "pagina_web" );
      property.put( "value", String.valueOf( tiendas.getPagina_web() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "created" );
      property.put( "value", String.valueOf( tiendas.getCreated() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "updated" );
      property.put( "value", String.valueOf( tiendas.getUpdated() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "codigo_postal" );
      property.put( "value", String.valueOf( tiendas.getCodigo_postal() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "email" );
      property.put( "value", String.valueOf( tiendas.getEmail() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "telefono" );
      property.put( "value", String.valueOf( tiendas.getTelefono() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "nombre_fabricante" );
      property.put( "value", String.valueOf( tiendas.getNombre_fabricante() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "latitud" );
      property.put( "value", String.valueOf( tiendas.getLatitud() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "numero" );
      property.put( "value", String.valueOf( tiendas.getNumero() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "direccion" );
      property.put( "value", String.valueOf( tiendas.getDireccion() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "longitud" );
      property.put( "value", String.valueOf( tiendas.getLongitud() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "ownerId" );
      property.put( "value", String.valueOf( tiendas.getOwnerId() ) );
      properties.add( property );
                                                                }
    else if( table.equals( "fabricante" ) )
    {
      fabricante fabricante = (fabricante) RetrieveRecordActivity.getResultObject();
      HashMap<String, String> property;
      property = new HashMap<String, String>();
      property.put( "property", "codigo_postal" );
      property.put( "value", String.valueOf( fabricante.getCodigo_postal() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "ownerId" );
      property.put( "value", String.valueOf( fabricante.getOwnerId() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "ciudad" );
      property.put( "value", String.valueOf( fabricante.getCiudad() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "objectId" );
      property.put( "value", String.valueOf( fabricante.getObjectId() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "pais" );
      property.put( "value", String.valueOf( fabricante.getPais() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "updated" );
      property.put( "value", String.valueOf( fabricante.getUpdated() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "email" );
      property.put( "value", String.valueOf( fabricante.getEmail() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "nombre_fabricante" );
      property.put( "value", String.valueOf( fabricante.getNombre_fabricante() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "created" );
      property.put( "value", String.valueOf( fabricante.getCreated() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "numero" );
      property.put( "value", String.valueOf( fabricante.getNumero() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "telefono" );
      property.put( "value", String.valueOf( fabricante.getTelefono() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "tipo_de_via" );
      property.put( "value", String.valueOf( fabricante.getTipo_de_via() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "direccion" );
      property.put( "value", String.valueOf( fabricante.getDireccion() ) );
      properties.add( property );
                                                            
      property = new HashMap<String, String>();
      property.put( "property", "pagina_web" );
      property.put( "value", String.valueOf( fabricante.getPagina_web() ) );
      properties.add( property );
                                                                }

    ListAdapter adapter = new SimpleAdapter( this, properties, R.layout.property_row, new String[] { "property", "value" }, new int[] { R.id.property, R.id.value } );
    propertiesView.setAdapter( adapter );
  }

  private void initRelationList()
  {
    List<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
    BackendlessCollection collection = RetrieveRecordActivity.getResultCollection();

    for( Object object : collection.getCurrentPage() )
    {
      if( table.equals( "marca" ) )
      {
        marca marca = (marca) object;
        String propertyValue = "";
        String getterMethodName = "get".concat( property.substring( 0, 1 ).toUpperCase().concat( property.substring( 1 ) ) );
        try
        {
          propertyValue = String.valueOf( marca.getClass().getDeclaredMethod( getterMethodName ).invoke( marca ) );
        }
        catch( InvocationTargetException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        catch( NoSuchMethodException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        catch( IllegalAccessException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        if( relation.equals( "modelo_eBike" ) )
                                                                        
        {
          if( relatedProperty.equals( "suspension" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getSuspension() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "tipo_sensor" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getTipo_sensor() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "created" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getCreated() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "tipo_de_uso" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getTipo_de_uso() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "tipo_cuadro" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getTipo_cuadro() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "precio" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getPrecio() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "ubicacion_motor" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getUbicacion_motor() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "puntos_de_venta" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getPuntos_de_venta() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "peso_total" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getPeso_total() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "material_del_cuadro" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getMaterial_del_cuadro() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "velocidades" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getVelocidades() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "tipo_display" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getTipo_display() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "foto" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getFoto() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "autonomia" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getAutonomia() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "pagina_web" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getPagina_web() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "ownerId" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getOwnerId() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "modelo" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getModelo() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "objectId" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getObjectId() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "tamano_ruedas" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getTamano_ruedas() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "updated" ) )
          {
            List<eBike> modelo_eBikeRelation = marca.getModelo_eBike();
            if( modelo_eBikeRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( eBike item : modelo_eBikeRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getUpdated() ) );
                rows.add( row );
              }
            }
          }

        }
      else if( relation.equals( "nombre_fabricante" ) )
                                                                        
        {
          if( relatedProperty.equals( "codigo_postal" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getCodigo_postal() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "ownerId" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getOwnerId() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "ciudad" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getCiudad() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "objectId" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getObjectId() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "pais" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getPais() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "updated" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getUpdated() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "email" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getEmail() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "nombre_fabricante" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getNombre_fabricante() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "created" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getCreated() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "numero" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getNumero() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "telefono" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getTelefono() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "tipo_de_via" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getTipo_de_via() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "direccion" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getDireccion() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "pagina_web" ) )
          {
            List<fabricante> nombre_fabricanteRelation = marca.getNombre_fabricante();
            if( nombre_fabricanteRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( fabricante item : nombre_fabricanteRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getPagina_web() ) );
                rows.add( row );
              }
            }
          }

        }

      }
      else if( table.equals( "eBike" ) )
      {
        eBike eBike = (eBike) object;
        String propertyValue = "";
        String getterMethodName = "get".concat( property.substring( 0, 1 ).toUpperCase().concat( property.substring( 1 ) ) );
        try
        {
          propertyValue = String.valueOf( eBike.getClass().getDeclaredMethod( getterMethodName ).invoke( eBike ) );
        }
        catch( InvocationTargetException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        catch( NoSuchMethodException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        catch( IllegalAccessException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        if( relation.equals( "marca" ) )
                                                                        
        {
          if( relatedProperty.equals( "objectId" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getObjectId() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "nombre" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getNombre() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "ciudad" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getCiudad() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "pais" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getPais() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "tipo_de_via" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getTipo_de_via() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "pagina_web" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getPagina_web() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "created" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getCreated() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "updated" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getUpdated() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "codigo_postal" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getCodigo_postal() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "email" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getEmail() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "telefono" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getTelefono() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "nombre_fabricante" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getNombre_fabricante() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "latitud" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getLatitud() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "numero" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getNumero() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "direccion" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getDireccion() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "longitud" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getLongitud() ) );
                rows.add( row );
              }
            }
          }
          else if( relatedProperty.equals( "ownerId" ) )
          {
            List<tiendas> marcaRelation = eBike.getMarca();
            if( marcaRelation.isEmpty() )
            {
              HashMap<String, String> row = new HashMap<String, String>();
              row.put( "property", propertyValue );
              row.put( "value", "No relation" );
              rows.add( row );
            }
            else
            {
              for( tiendas item : marcaRelation )
              {
                HashMap<String, String> row = new HashMap<String, String>();
                row.put( "property", propertyValue );
                row.put( "value", String.valueOf( item.getOwnerId() ) );
                rows.add( row );
              }
            }
          }

        }

      }
      else if( table.equals( "tiendas" ) )
      {
        tiendas tiendas = (tiendas) object;
        String propertyValue = "";
        String getterMethodName = "get".concat( property.substring( 0, 1 ).toUpperCase().concat( property.substring( 1 ) ) );
        try
        {
          propertyValue = String.valueOf( tiendas.getClass().getDeclaredMethod( getterMethodName ).invoke( tiendas ) );
        }
        catch( InvocationTargetException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        catch( NoSuchMethodException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        catch( IllegalAccessException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        
      }
      else if( table.equals( "fabricante" ) )
      {
        fabricante fabricante = (fabricante) object;
        String propertyValue = "";
        String getterMethodName = "get".concat( property.substring( 0, 1 ).toUpperCase().concat( property.substring( 1 ) ) );
        try
        {
          propertyValue = String.valueOf( fabricante.getClass().getDeclaredMethod( getterMethodName ).invoke( fabricante ) );
        }
        catch( InvocationTargetException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        catch( NoSuchMethodException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        catch( IllegalAccessException e )
        {
          Toast.makeText( this, e.getMessage(), Toast.LENGTH_LONG );
        }
        
      }

    }
    ListAdapter adapter = new SimpleAdapter( this, rows, R.layout.property_row, new String[] { "property", "value" }, new int[] { R.id.property, R.id.value } );
    propertiesView.setAdapter( adapter );
}
}