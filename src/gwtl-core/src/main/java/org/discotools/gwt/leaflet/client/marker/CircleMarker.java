package org.discotools.gwt.leaflet.client.marker;

import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.jsobject.JSObject;
import org.discotools.gwt.leaflet.client.types.LatLng;

public class CircleMarker extends Marker {

	public CircleMarker(LatLng latLng, Options options) {
		super(create(latLng.getJSObject(), options.getJSObject()));
	}
	
	public static native JSObject create(JSObject latlng, JSObject options)/*-{
		return new $wnd.L.circleMarker(latlng,options);
	}-*/;
}
