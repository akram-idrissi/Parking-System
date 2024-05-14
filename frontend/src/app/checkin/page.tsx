'use client'

import React, { useState } from 'react';
import { useRouter, usePathname, useSearchParams } from 'next/navigation'
import { useEffect } from 'react';
import {checkin} from '../../component/booking';

import '../../css/global.css';

export interface UserInfo {
  username: string;
  /* email: string; */
  password: string;
}

export interface VehicleInfo {
  brand: string;
  model: string;
  plate: string;
  color: string;
}

export interface URLParams {
  id: string;
  checkin: string;
  checkout: string;
}

function formatDateForInput(date: Date): string {
  const year: number = date.getFullYear();
  let month: string | number = date.getMonth() + 1;
  let day: string | number = date.getDate();
  let hours: string | number = date.getHours();
  let minutes: string | number = date.getMinutes();

  // Add leading zeros if needed
  month = month < 10 ? `0${month}` : month;
  day = day < 10 ? `0${day}` : day;
  hours = hours < 10 ? `0${hours}` : hours;
  minutes = minutes < 10 ? `0${minutes}` : minutes;

  return `${year}-${month}-${day}T${hours}:${minutes}`;
}

export default function Checkin() {
  const pathname = usePathname();
  const searchParams = useSearchParams();

  const [userInfo, setUserInfo] = useState<UserInfo>({ username: '', password: '' });
  const [vehicleInfo, setVehicleInfo] = useState<VehicleInfo>({ brand: '', model: '', plate: '', color: '' });
  const [URLParams, setUrlParams] = useState<URLParams>({ id: '', checkin: '', checkout: '' });

  const today: Date = new Date();
  const oneYearFromNow: Date = new Date(today.getFullYear() + 1, today.getMonth(), today.getDate());

  const [checkinTime, setCheckinTime] = useState<string>(formatDateForInput(today));
  const [checkoutTime, setCheckoutTime] = useState<string>(formatDateForInput(today));

  useEffect(() => {
    let url = `${pathname}?${searchParams}`
    let queryParams = new URLSearchParams(url.split('?')[1]);

    setUrlParams({
      id: queryParams.get('id') ?? '',
      checkin: '',
      checkout: '',
    })
  }, [pathname, searchParams])


  const onButtonClick = async ()  => {
    console.log(URLParams.checkin + " " + URLParams.checkout);
    checkin(URLParams, userInfo, vehicleInfo);
  };

  return (
    <div className='checkin-wrapper'>
      <main className='checkin-page container'>
        <h1>Checkin Page</h1>
      </main>

      <form className='container'>
        <div className='sub-forms'>
          <h3>User Information</h3>
          <div className='user-form'>
            <div className="inputs">
              <label htmlFor="username">Username:</label>
              <input type="text" id="username" name="username" value={userInfo.username} onChange={(e) => setUserInfo({ ...userInfo, username: e.target.value })} required />
            </div>
            {/* <div className="inputs">
              <label htmlFor="email">Email:</label>
              <input type="email" id="email" name="email" value={userInfo.email} onChange={(e) => setUserInfo({ ...userInfo, email: e.target.value })} required />
            </div> */}
            <div className="inputs">
              <label htmlFor="password">Password:</label>
              <input type="password" id="password" name="password" value={userInfo.password} onChange={(e) => setUserInfo({ ...userInfo, password: e.target.value })} required />
            </div>
          </div>
        </div>

        <div className='sub-forms'>
          <h3>Vehicle Information</h3>
          <div className='vehicle-form'>
            <div className="inputs">
              <label htmlFor="brand">Brand:</label>
              <input type="text" id="brand" name="brand" value={vehicleInfo.brand} onChange={(e) => setVehicleInfo({ ...vehicleInfo, brand: e.target.value })} required />
            </div>
            <div className="inputs">
              <label htmlFor="model">Model:</label>
              <input type="text" id="model" name="model" value={vehicleInfo.model} onChange={(e) => setVehicleInfo({ ...vehicleInfo, model: e.target.value })} required />
            </div>
            <div className="inputs">
              <label htmlFor="plate">Plate:</label>
              <input type="text" id="plate" name="plate" value={vehicleInfo.plate} onChange={(e) => setVehicleInfo({ ...vehicleInfo, plate: e.target.value })} required />
            </div>
            <div className="inputs">
              <label htmlFor="color">Color:</label>
              <input type="text" id="color" name="color" value={vehicleInfo.color} onChange={(e) => setVehicleInfo({ ...vehicleInfo, color: e.target.value })} required />
            </div>
          </div>
        </div>

        <div className='sub-forms'>
          <h3>Duration</h3>
          <div className='vehicle-form'>
            <div className="inputs">
              <label htmlFor="checkin-time">From:</label>
              <input
                type="datetime-local"
                id="checkin-time"
                name="checkin-time"
                value={URLParams.checkin}
                min={formatDateForInput(today)}
                max={formatDateForInput(oneYearFromNow)}
                onChange={(e) => setUrlParams({ ...URLParams, checkin: e.target.value })}
              />
            </div>

            <div className="inputs">
              <label htmlFor="checkout-time">To:</label>
              <input
                type="datetime-local"
                id="checkout-time"
                name="checkout-time"
                value={URLParams.checkout}
                min={formatDateForInput(today)}
                max={formatDateForInput(oneYearFromNow)}
                onChange={(e) => setUrlParams({ ...URLParams, checkout: e.target.value })}
              />
            </div>
            
            
          </div>
        </div>
      </form>
        <button className='container' type="button" onClick={onButtonClick}>Book Now</button>
    </div>
  );
}
