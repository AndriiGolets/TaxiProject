var map;
var markers = [];
var placeSearch, autocomplete1, autocomplete2;

var goFrom = new google.maps.Marker();
var goTo = new google.maps.Marker();

google.maps.event.addDomListener(window, 'load', googleMapInitialize);

function googleMapInitialize() {
    if ($("#googleMap").length) {
        var mapProp = {
            center: new google.maps.LatLng(50.433588, 30.5932734),
            zoom: 11,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            disableDefaultUI: true,
            panControl: false
        };
        map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
    }
}

function setMarkerByAddress(address, key) {

    $.post("google-map", {
            key: "get-lat-lng",
            address: address
        },
        function (data) {
            var latLng = new google.maps.LatLng(data.lat, data.lng);
            var marker = new google.maps.Marker({
                position: latLng,
                map: map,
                title: address
            });
            if (key === "goFrom") {
                goFrom.setMap(null);
                goFrom = marker;
            } else if ((key === "goTo")) {
                goTo.setMap(null);
                goTo = marker;
            } else {
                marker.setMap(map);
                markers.push(marker);
            }
        }, "json"
    );
}

function displayRoute(address1, address2) {
    $.post("google-map", {
            key: "get-address-x2",
            address1: address1,
            address2: address2
        },
        function (data) {
            var start = new google.maps.LatLng(data.lat1, data.lng1);
            var end = new google.maps.LatLng(data.lat2, data.lng2);

            var directionsDisplay = new google.maps.DirectionsRenderer();// also, constructor can get "DirectionsRendererOptions" object
            directionsDisplay.setMap(map); // map should be already initialized.

            var request = {
                origin: start,
                destination: end,
                travelMode: google.maps.TravelMode.DRIVING
            };
            var directionsService = new google.maps.DirectionsService();
            directionsService.route(request, function (response, status) {
                if (status == google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(response);
                }
            });
        }, "json"
    );
}

function displayOrders() {
    $.post("google-map", {
            key: "get-orders"
        },
        function (data) {
            for (var i = 0; i < data.length; i++) {

                var latLng = new google.maps.LatLng(data[i].lat, data[i].lng);
                var marker = new google.maps.Marker({
                    position: latLng,
                    map: map,
                    title: data[i].address
                });

                marker.addListener('click', function () {
                    var title = this.getTitle();
                    userPhone = title.split("tel: ")[1];
                    chooseOrder(userPhone);
                });

                markers.push(marker);
            }
        }, "json"
    );
}

function initFromAutocomplete() {
    autocomplete1 = new google.maps.places.Autocomplete(
        /** @type {!HTMLInputElement} */(document.getElementById('goFrom')), {
            types: ['geocode'],
            componentRestrictions: {country: 'ua'}
        });
    autocomplete1.addListener('place_changed', fillInAddress);
    setTimeout(geolocate(autocomplete1), 700);
}

function initToAutocomplete() {
    autocomplete2 = new google.maps.places.Autocomplete(
        /** @type {!HTMLInputElement} */(document.getElementById('goTo')), {
            types: ['geocode'],
            componentRestrictions: {country: 'ua'}
        });
    setTimeout(geolocate(autocomplete2), 1000);
}

// [START region_fillform]
function fillInAddress() {

}
// [END region_fillform]

// [START region_geolocation]
// Bias the autocomplete object to the user's geographical location,
// as supplied by the browser's 'navigator.geolocation' object.
function geolocate(autocomplete) {
    var geolocation = {
        lat: 50.433588,
        lng: 30.5932734
    };
    var circle = new google.maps.Circle({
        center: geolocation,
        radius: 20000
    });
    autocomplete.setBounds(circle.getBounds());
}


// Sets the map on all markers in the array.
function setMapOnAll(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}

// Removes the markers from the map, but keeps them in the array.
function clearMarkers() {
    setMapOnAll(null);
    goFrom.setMap(null);
    goTo.setMap(null);
}

// Shows any markers currently in the array.
function showMarkers() {
    setMapOnAll(map);
}

// Deletes all markers in the array by removing references to them.
function deleteMarkers() {
    clearMarkers();
    markers = [];
}
