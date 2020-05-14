import React,{useState} from 'react';
import ReactMap,{Marker,Popup} from 'react-map-gl';
import * as PointData from '../../../Data/vehicle-locations.json';
import {Button} from '@material-ui/core';
import LocImg from '../../../Assets/images/scooter-svgrepo-com (1).svg';
import './Mapbox.css';
import locationsService from '../../../repository/axiosLocationsRepository';   

export default function Map({handleSelect}){
    const[locations,setLocations] = useState(locationsService.fetchLocations); //can't map this json in a functional component.

    const[viewport, setViewport] = useState({
        latitude: 41.994010,
        longitude: 21.435920,
        width: '100%',
        height: '80vh',
        zoom: 10
    });
    const styles = {
       borderRadius: "3px"
    };

    const[selectedPlace, setSelectedPlace] = useState(null);

    
    return (<div style={{margin: '1em 2em'}}>
        <ReactMap {...viewport}
         mapboxApiAccessToken="pk.eyJ1IjoiaHJpc3RpamFuc3JtIiwiYSI6ImNrMmNmdGhnejA0aXgzYm8wbXlzcGdjcXcifQ.u48U8MvhK5IPyoiyci6jXw"
         mapStyle = "mapbox://styles/hristijansrm/ck2cwqhel0fta1co4nkwkadlz"
         onViewportChange ={(viewport)=>{setViewport(viewport);}}
         >
         <div className='map-insturctions'>
            <h3>Начин на користење на мапата</h3>
            <p>
                За повеќе детали, притиснете на локациите, каде ве чека голем избор на тротинети.
            </p>
         </div>
             {PointData.features.map((point)=>(
                 <Marker key={point.properties.Loc_ID}
                    latitude={point.properties.Coordinates[0]}  longitude={point.properties.Coordinates[1]}>
                     <Button size="small" style={styles} 
                        onClick = {e => {
                         e.preventDefault();
                         setSelectedPlace(point);
                         handleSelect(point);
                     }}>
                     <img src={LocImg} style={{width:"3.2em",height:"3.2em"}} alt="Rental locations"></img>
                     </Button>
                 </Marker>
             ))}
            {console.log(locations)}
             {selectedPlace ? ( <Popup latitude={selectedPlace.properties.PopupCoordinates[0]} 
                       longitude={selectedPlace.properties.PopupCoordinates[1]}
                       onClose= {()=>{
                           setSelectedPlace(null);
                       }}
                       >
                    <div>
                        <h2>{selectedPlace.properties.Name}</h2>
                        <p>{selectedPlace.properties.Description}</p>
                    </div>
                </Popup>
             ) : null}
         </ReactMap>
    </div>
    );
}