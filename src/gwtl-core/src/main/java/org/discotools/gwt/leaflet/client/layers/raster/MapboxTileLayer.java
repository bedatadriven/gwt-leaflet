package org.discotools.gwt.leaflet.client.layers.raster;

import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.jsobject.JSObject;
import org.discotools.gwt.leaflet.client.layers.ILayer;

public class MapboxTileLayer extends ILayer {
		
	public MapboxTileLayer(String id, Options options) {
		super(createMapBoxLayer(id, options.getJSObject()));
	}
	
	public MapboxTileLayer(String id) {
		this(id, new Options());
	}

	public static native JSObject createMapBoxLayer(String id, JSObject options)/*-{				
		return new $wnd.L.mapbox.tileLayer(id, options);
	}-*/;
}
