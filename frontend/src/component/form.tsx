'use client'

import { useState } from 'react';

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

export default function Form() {
  const today: Date = new Date();
  const oneYearFromNow: Date = new Date(today.getFullYear() + 1, today.getMonth(), today.getDate());

  const [checkinTime, setCheckinTime] = useState<string>(formatDateForInput(today));
  const [checkoutTime, setCheckoutTime] = useState<string>(formatDateForInput(today));

  return (
    <form>
      <div className="checkin">
        <label htmlFor="checkin-time">From:</label>
        <input
          type="datetime-local"
          id="checkin-time"
          name="checkin-time"
          value={checkinTime}
          min={formatDateForInput(today)}
          max={formatDateForInput(oneYearFromNow)}
          onChange={(e) => setCheckinTime(e.target.value)}
        />
      </div>

      <div className="checkout">
        <label htmlFor="checkout-time">To:</label>
        <input
          type="datetime-local"
          id="checkout-time"
          name="checkout-time"
          value={checkoutTime}
          min={formatDateForInput(today)}
          max={formatDateForInput(oneYearFromNow)}
          onChange={(e) => setCheckoutTime(e.target.value)}
        />
      </div>

      <button type="submit">search</button>

    </form>
  );
}
