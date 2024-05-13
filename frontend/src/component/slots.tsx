import { useState } from 'react';
import Link from 'next/link';


interface Slot {
    id: number;
    status: string;
}

interface SlotsProps {
    data: Slot[];
    checkin: string;
    checkout: string;
}

interface CheckinProps {
    checkinTime: string;
    checkoutTime: string;
}


export default function Slots({ data, checkin, checkout }: SlotsProps) {

    const [selectedSlot, setSelectedSlot] = useState<number>(-1);
    const [checkinProps, setCheckinsProps] = useState<CheckinProps | any>();

    const onSlotClick = (slotId: number) => {
        setSelectedSlot(slotId === selectedSlot ? -1 : slotId);
        setCheckinsProps({
            checkinTime: checkin,
            checkoutTime: checkout
        });
    };

    return (
        <div className="slots-wrapper">
            <h2>Parking Slots:</h2>
            <div className="slots container">
                {data.map((slot: any) => (
                        <div key={slot.id}
                            className={`slot ${slot.status === 'AVAILABLE' ? 'available' : 'busy'} ${selectedSlot === slot.id ? 'choosen' : ''}`}
                            onClick={() => onSlotClick(slot.id)}
                            >
                             <div>
                                slot <span className="font-for-nums">{slot.id}</span>
                             </div>
                            {slot.status === 'AVAILABLE' && selectedSlot === slot.id && (
                                
                                <Link className="book" href={{ pathname: '/checkin', query: {
                                                id: selectedSlot, 
                                                checkin: checkinProps.checkinTime, 
                                                checkout: checkinProps.checkoutTime}}} >
                                    Book Now
                                </Link>
                            )}
                        </div>
                ))}
            </div>
        </div>
    );
}
