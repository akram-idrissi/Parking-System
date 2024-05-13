import axios, { AxiosError } from 'axios';

interface FindSlotsResponse {
  slots: any;
  checkinTime: string;
  checkoutTime: string;
}

export async function findSlots(checkinTime: string, checkoutTime: string) {
  try {
    const response = await axios.get('http://localhost:8099/slots');
    const responseData: FindSlotsResponse = {
      slots: response.data.slots,
      checkinTime,
      checkoutTime
    };
    return responseData;
  } catch (error: unknown) {
    if (axios.isAxiosError(error)) {
      const axiosError = error as AxiosError;
      throw new Error(`Axios error: ${axiosError.message}`);
    } else 
      throw new Error('Unknown error occurred');
  }
}
