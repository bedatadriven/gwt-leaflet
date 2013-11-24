package org.discotools.gwt.leaflet.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

public interface LeafletClientBundle
  extends ClientBundle {

//    @Source("leaflet-src.js")
    @Source("mapbox-v1.5.0.js")
    TextResource baseScript();

    @Source("mapbox-v1.5.0.css")
    @CssResource.NotStrict
    CssResource css();

    @Source("images/layers.png")
    ImageResource layers();
}
