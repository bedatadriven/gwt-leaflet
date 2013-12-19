package org.discotools.gwt.leaflet.client.controls;

import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.jsobject.JSObject;
import org.discotools.gwt.leaflet.client.map.Map;

import com.google.gwt.dom.client.Element;

/**
 * <b>Base class for all Leaflet controls</b>
 * <p>
 * Implements IControl interface. You can add controls to the map like this:
 * 
 * <ul>
 * <li>control.addTo(map);
 * <li>map.addControl(control);
 * </ul>
 * 
 * </p>
 * 
 * @author kengu
 * @author Lionel Leiva-Marcon
 * 
 * @see <a href="http://leaflet.cloudmade.com/reference.html#control">L.Control
 *      (Leaflet API)</a>
 */
public class Control extends IControl {

	/**
	 * The position of the control (one of the map corners).
	 */
	public static final String POSITION = "position";

	protected Control(JSObject element) {
		super(element);
	}

	/**
	 * Custom constructor
	 * @param options
	 */
	public Control(Options options) {
		this(options, false, false);
	}
	
	/**
	 * Advanced constructor
	 * When custom controls have to be create by extending this class, methods onAdd and onRemove
	 * must be defined.
	 * If your custom controls are not set in the library itself (ie scale, zoom),
	 * this is a very convenience constructor.
	 * @param options
	 * @param onAdd When true, register 'onAdd' method in subclass
	 * @param onRemove When true, register 'onRemove' method in subclass
	 */
	public Control(Options options, boolean onAdd, boolean onRemove) {
		this(ControlImpl.create(options.getJSObject()));
		if(onAdd) {
			ControlImpl.onAdd(this, getJSObject());
		}
		if(onRemove) {
			ControlImpl.onRemove(this, getJSObject());			
		}
		
	} 

	// --------------------------------------------------------
	// Control base implementation
	// --------------------------------------------------------

	/**
	 * Returns the current position of the control.
	 * 
	 * @return
	 */
	public String getPosition() {
		return ControlImpl.getPosition(getJSObject());
	}

	/**
	 * Sets the position of the control. See control positions.
	 * 
	 * @param position
	 */
	public Control setPosition(String position) {
		ControlImpl.setPosition(getJSObject(), position);
		return this;
	}

	/**
	 * Adds the control to the map.
	 * 
	 * @param map
	 */
	public Control addTo(Map map) {
		ControlImpl.addTo(getJSObject(), map.getJSObject());
		return this;
	}

	/**
	 * Removes the control from the map.
	 * 
	 * @param map
	 */
	public Control removeFrom(Map map) { 
		ControlImpl.removeFrom(getJSObject(), map.getJSObject());
		return this;
	}
	
	public Element getContainer() {
		return getNativeContainer(getJSObject());
	}
	
	// TODO: change this to user .getContainer() when we upgrade to leaflet 0.7.x
	private static native Element getNativeContainer(JSObject obj) /*-{
		return obj._container;
	}-*/;

}
