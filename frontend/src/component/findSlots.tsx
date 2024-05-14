import axios, { AxiosError } from 'axios';

interface FindSlotsResponse {
  slots: any;
}

export async function findSlots() {
  try {
    const response = await axios.get('http://localhost:8099/slots');
    const responseData: FindSlotsResponse = {
      slots: response.data.slots,
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
