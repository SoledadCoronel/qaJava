
// require the dev-dependencies

var chai = require('chai');
var chaiHttp = require('chai-http');
var should = chai.should();

chai.use(chaiHttp);

describe('GET /platforms', () => {
	it('it should GET all the platforms', (done) => {
		chai.request('http://platform-ms.cd.gointegro.net')
		.get(/platforms)
		end((err, res) => {
			res.should.have.status(200);
			res.body.should.be.a('array');
			done();
		});
	});
});


