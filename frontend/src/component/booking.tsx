import axios, { AxiosError } from 'axios';
import { URLParams, UserInfo, VehicleInfo } from '../app/checkin/page';


export async function checkin(params: URLParams, user: UserInfo, vehicle: VehicleInfo) {
    try {
        const response = await axios.post('http://localhost:8099/checkin',
            { user: user, params: params, vehicle: vehicle });
        return response.data;
    } catch (error: unknown) {
        if (axios.isAxiosError(error)) {
            const axiosError = error as AxiosError;
            throw new Error(`Axios error: ${axiosError.message}`);
        } else
            throw new Error('Unknown error occurred');
    }
}

export async function checkout(slotID: number) {
    try {
        const response = await axios.post('http://localhost:8099/checkout', { slotID });
        return response.data;
    } catch (error: unknown) {
        if (axios.isAxiosError(error)) {
            const axiosError = error as AxiosError;
            throw new Error(`Axios error: ${axiosError.message}`);
        } else
            throw new Error('Unknown error occurred');
    }
}
