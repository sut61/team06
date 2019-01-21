import { RoutingMainModule } from './routing-main.module';

describe('RoutingMainModule', () => {
  let routingMainModule: RoutingMainModule;

  beforeEach(() => {
    routingMainModule = new RoutingMainModule();
  });

  it('should create an instance', () => {
    expect(routingMainModule).toBeTruthy();
  });
});
